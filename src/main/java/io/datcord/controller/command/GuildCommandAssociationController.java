package io.datcord.controller.command;

import io.datcord.entity.command.Command;
import io.datcord.service.command.CommandService;
import io.datcord.service.command.GuildCommandAssociationService;
import io.datcord.service.command.impl.GuildCommandAssociationServiceImpl;
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
 * Controller class for handling guild command associations.
 */
@RestController
@RequestMapping("api/v1/commands")
@RequiredArgsConstructor
public class GuildCommandAssociationController {

    /**
     * Logger instance for logging information related to guild command associations.
     */
    private static final Logger logger = LoggerFactory.getLogger(GuildCommandAssociationController.class);


    /**
     * Retrieves all commands associated with a guild based on guild ID.
     *
     * @param response the HttpServletResponse
     * @param guildId  the ID of the guild
     * @return ResponseEntity containing a collection of Command objects
     */
    @GetMapping("/guild")
    public ResponseEntity<Collection<Command>> getAllCommandsForGuildId(HttpServletResponse response, @RequestParam long guildId) {
        logger.debug("Received request for all available commands from guild {}", guildId);

        Collection<Command> commands = new ArrayList<>();
        Collection<Integer> availableCommandIds = guildCommandAssociationService.readAllCommandIdForGuildId(guildId);

        availableCommandIds.forEach(commandId -> {
            Command command = commandService.readCommand(commandId);
            logger.debug("Found command {}", command);
            if (command != null) {
                logger.debug("Adding command {}", command);
                commands.add(command);
            }
        });

        logger.debug("Found {} available commands for guild {}", availableCommandIds.size(), guildId);
        logger.debug("Found {} actual commands", commands.size());

        return ResponseEntity.of(Optional.of(commands));
    }

    /**
     * Service for managing guild command associations.
     */
    private final GuildCommandAssociationService guildCommandAssociationService;

    /**
     * Service for handling commands.
     */
    private final CommandService commandService;
}
