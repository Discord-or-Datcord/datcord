package io.datcord.service.command;

import io.datcord.entity.command.GuildCommandAssociation;

import java.util.Collection;

/**
 * Service interface for managing GuildCommandAssociation entities.
 * This interface provides methods for reading the associations
 * between guilds and commands based on guild ID or command ID.
 */
public interface GuildCommandAssociationService {

    /**
     * Retrieves all command IDs associated with a specific guild ID.
     *
     * @param id the ID of the guild
     * @return a Collection of command IDs
     */
    Collection<Integer> readAllCommandIdForGuildId(long id);

    /**
     * Retrieves all guild IDs associated with a specific command ID.
     *
     * @param id the ID of the command
     * @return a Collection of guild IDs
     */
    Collection<Long> readAllGuildIdForCommandId(int id);
}
