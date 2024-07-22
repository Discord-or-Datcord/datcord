package io.datcord.service.command.impl;

import io.datcord.entity.command.Command;
import io.datcord.repository.command.CommandRepository;
import io.datcord.service.command.CommandService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Implementation of {@link CommandService} that handles command operations.
 */
@Service
@RequiredArgsConstructor
public class CommandServiceImpl implements CommandService {

    /**
     * Logger instance for logging information related to command operations.
     */
    private static final Logger logger = LoggerFactory.getLogger(CommandServiceImpl.class);

    /**
     * Retrieves a command based on its ID.
     *
     * @param id the ID of the command to retrieve
     * @return the Command object corresponding to the ID, or null if not found
     */
    @Override
    public Command readCommand(int id) {
        logger.debug("Reading command {}", id);
        Command command = commandRepository.findById(id).orElse(null);
        logger.debug("Found command {}", command);
        if (command == null) {
            logger.debug("No command with id {} found", id);
        }

        return command;
    }

    /**
     * Repository for accessing command data.
     */
    private final CommandRepository commandRepository;
}
