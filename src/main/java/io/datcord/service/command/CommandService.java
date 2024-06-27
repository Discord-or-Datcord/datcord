package io.datcord.service.command;

import io.datcord.entity.command.Command;

import java.util.Collection;


/**
 * Interface representing a service for handling commands.
 */
public interface CommandService {

        /**
         * Reads a command given its ID.
         *
         * @param id the ID of the command to read
         * @return the Command object corresponding to the ID
         */
        Command readCommand(int id);

}
