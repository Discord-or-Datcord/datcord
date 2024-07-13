package io.datcord.service.feature;

import java.util.Collection;

/**
 * Service interface for managing GuildFeatureAssociation entities.
 * This interface provides methods for reading the associations
 * between guilds and features based on guild ID or feature ID.
 */
public interface GuildFeatureAssociationService {

    /**
     * Retrieves all feature IDs associated with a specific guild ID.
     *
     * @param id the ID of the guild
     * @return a Collection of feature IDs
     */
    Collection<Integer> readAllFeatureIdForGuildId(long id);

    /**
     * Retrieves all guild IDs associated with a specific feature ID.
     *
     * @param id the ID of the feature
     * @return a Collection of guild IDs
     */
    Collection<Long> readAllGuildIdForFeatureId(int id);
}
