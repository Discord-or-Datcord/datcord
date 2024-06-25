package io.datcord.service.command;

import io.datcord.entity.command.Command;

/**
 * This interface defines methods for handling CRUD (Create, Read, Update, Delete) operations
 * related to commands.
 */
public interface CommandService {

        /**
         * Creates a new command.
         *
         * @param command The command object to create.
         * @return The created command object.
         */
        Command create(Command command);

        //TODO Other CRUD methods can be added here, such as:
        //TODO  Command read(Long id);
        //TODO  Command update(Long id, Command command);
        //TODO  void delete(Long id);
}
