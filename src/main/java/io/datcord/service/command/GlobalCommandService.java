package io.datcord.service.command;

import io.datcord.entity.command.GlobalCommand;

import java.util.Collection;


/**
 * Interface representing a service for handling commands.
 */
public interface GlobalCommandService {

        /**
         * Reads all commands in the table
         * @return a collection of every command in the table
         */
        Collection<GlobalCommand> readAllGlobalCommands();



}
