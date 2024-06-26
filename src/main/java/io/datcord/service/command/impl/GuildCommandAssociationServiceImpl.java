package io.datcord.service.command.impl;

import io.datcord.repository.GuildCommandAssociationRepository;
import io.datcord.service.command.GuildCommandAssociationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Implementation of the GuildCommandAssociationService interface.
 * This service provides methods to retrieve command IDs by guild ID
 * and guild IDs by command ID, utilizing the GuildCommandAssociationRepository.
 */
@Service
@RequiredArgsConstructor
public class GuildCommandAssociationServiceImpl implements GuildCommandAssociationService {

    private static final Logger logger = LoggerFactory.getLogger(GuildCommandAssociationServiceImpl.class);

    /**
     * Retrieves all command IDs associated with a specific guild ID.
     * Logs a debug message if no command IDs are found.
     *
     * @param id the ID of the guild
     * @return a Collection of command IDs, or null if none found
     */
    @Override
    public Collection<Integer> readAllCommandIdForGuildId(long id) {
        Collection<Integer> commandIds = guildCommandAssociationRepository.findAllCommandIdsByGuildId(id).orElse(null);
        if (commandIds == null || commandIds.isEmpty()) {
            logger.debug("No commands found for guild id: {}", id);
        }
        return commandIds;
    }

    /**
     * Retrieves all guild IDs associated with a specific command ID.
     * Logs a debug message if no guild IDs are found.
     *
     * @param id the ID of the command
     * @return a Collection of guild IDs, or null if none found
     */
    @Override
    public Collection<Long> readAllGuildIdForCommandId(int id) {
        Collection<Long> guildIds = guildCommandAssociationRepository.findAllGuildIdsByCommandId(id).orElse(null);
        if (guildIds == null || guildIds.isEmpty()) {
            logger.debug("No guilds have command: {}", id);
        }
        return guildIds;
    }

    private final GuildCommandAssociationRepository guildCommandAssociationRepository;
}
