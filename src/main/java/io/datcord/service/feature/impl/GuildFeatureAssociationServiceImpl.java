package io.datcord.service.feature.impl;

import io.datcord.repository.GuildCommandAssociationRepository;
import io.datcord.repository.GuildFeatureAssociationRepository;
import io.datcord.service.command.GuildCommandAssociationService;
import io.datcord.service.feature.GuildFeatureAssociationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Implementation of the GuildFeatureAssociationService interface.
 * This service provides methods to retrieve feature IDs by guild ID
 * and guild IDs by feature ID, utilizing the GuildFeatureAssociationRepository.
 */
@Service
@RequiredArgsConstructor
public class GuildFeatureAssociationServiceImpl implements GuildFeatureAssociationService {

    private static final Logger logger = LoggerFactory.getLogger(GuildFeatureAssociationServiceImpl.class);

    /**
     * Retrieves all command IDs associated with a specific guild ID.
     * Logs a debug message if no command IDs are found.
     *
     * @param id the ID of the guild
     * @return a Collection of command IDs, or null if none found
     */
    @Override
    public Collection<Integer> readAllFeatureIdForGuildId(long id) {
        Collection<Integer> featureIds = guildFeatureAssociationRepository.findAllFeatureIdsByGuildId(id).orElse(null);
        if (featureIds == null || featureIds.isEmpty()) {
            logger.debug("No features found for guild id: {}", id);
        }
        return featureIds;
    }

    /**
     * Retrieves all guild IDs associated with a specific feature ID.
     * Logs a debug message if no guild IDs are found.
     *
     * @param id the ID of the feature
     * @return a Collection of guild IDs, or null if none found
     */
    @Override
    public Collection<Long> readAllGuildIdForFeatureId(int id) {
        Collection<Long> guildIds = guildFeatureAssociationRepository.findAllGuildIdsByFeatureId(id).orElse(null);
        if (guildIds == null || guildIds.isEmpty()) {
            logger.debug("No guilds have feature: {}", id);
        }
        return guildIds;
    }

    private final GuildFeatureAssociationRepository guildFeatureAssociationRepository;
}
