package io.datcord.service.command.impl;

import io.datcord.Application;
import io.datcord.entity.command.Command;
import io.datcord.repository.CommandRepository;
import io.datcord.service.command.CommandService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * Implementation of the CommandService interface for handling CRUD operations related to commands.
 */
@Service
@RequiredArgsConstructor
public class CommandServiceImpl implements CommandService {

    /**
     * Command Service Logger instance
     */
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     * Creates a new command.
     *
     * @param command The command object to create.
     * @return The created command object.
     * @throws DataIntegrityViolationException If there's a data integrity violation during the creation process.
     */
    @Override
    public Command create(Command command) {
        try {
            Command savedCommand = commandRepository.save(command);
            return savedCommand;
        } catch (DataIntegrityViolationException e) {
            String message = e.getMessage();
            logger.error("Something went wrong with your request {}", message);
            throw new DataIntegrityViolationException("Something went wrong with your request: " + message);
        }
    }

    private final CommandRepository commandRepository;
}
