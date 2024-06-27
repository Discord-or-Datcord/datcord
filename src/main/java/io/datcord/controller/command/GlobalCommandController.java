package io.datcord.controller.command;

import io.datcord.entity.command.Command;
import io.datcord.entity.command.GlobalCommand;
import io.datcord.service.command.CommandService;
import io.datcord.service.command.GlobalCommandService;
import io.datcord.service.command.GuildCommandAssociationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


/**
 * Controller class for handling global commands
 */
@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class GlobalCommandController {

    /**
     * Logger instance for logging information related to global commands.
     */
    private static final Logger logger = LoggerFactory.getLogger(GlobalCommandController.class);


    /**
     * Retrieves all global commands
     * Shares an endpoint with commands for guilds but without the guild id parameter
     *
     * @param response the HttpServletResponse
     * @return ResponseEntity containing a collection of Command objects
     */
    @GetMapping("/commands")
    public ResponseEntity<Collection<Command>> getAllCommandsGlobalCommands(HttpServletResponse response) {
        logger.debug("Received request for all global commands");

        Collection<Command> commands = new ArrayList<>();
        Collection<GlobalCommand> globalCommands = globalCommandService.readAllGlobalCommands();

        globalCommands.forEach(globalCommand -> {
            Command command = commandService.readCommand(globalCommand.getCommandId());
            logger.debug("Found command {}", command);
            if (command != null) {
                logger.debug("Adding command {}", command);
                commands.add(command);
            }
        });

        logger.debug("Found {} available global commands", globalCommands.size());
        logger.debug("Found {} actual commands", commands.size());

        return ResponseEntity.of(Optional.of(commands));
    }

    /**
     * Service for managing global commands.
     */
    private final GlobalCommandService globalCommandService;

    /**
     * Service for handling commands.
     */
    private final CommandService commandService;
}
