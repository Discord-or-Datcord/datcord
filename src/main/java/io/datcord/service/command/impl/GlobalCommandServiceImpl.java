package io.datcord.service.command.impl;

import io.datcord.entity.command.GlobalCommand;
import io.datcord.repository.command.GlobalCommandRepository;
import io.datcord.service.command.GlobalCommandService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * Implementation of {@link io.datcord.service.command.GlobalCommandService} that handles command operations.
 */
@Service
@RequiredArgsConstructor
public class GlobalCommandServiceImpl implements GlobalCommandService {

    /**
     * Logger instance for logging information related to command operations.
     */
    private static final Logger logger = LoggerFactory.getLogger(GlobalCommandServiceImpl.class);


    /**
     * Retrieves all commands in the repository
     * @return a collection of every {@link GlobalCommand} in the repository
     */
    @Override
    public Collection<GlobalCommand> readAllGlobalCommands() {
        logger.debug("Reading all global commands");
        Collection<GlobalCommand> globalCommands = commandRepository.findAll();
        logger.debug("Found {} global commands",globalCommands.size());
        return globalCommands;
    }

    /**
     * Repository for accessing command data.
     */
    private final GlobalCommandRepository commandRepository;
}
