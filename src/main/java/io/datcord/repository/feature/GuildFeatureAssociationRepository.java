package io.datcord.repository.feature;

import io.datcord.entity.feature.GuildFeatureAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * Repository interface for GuildFeatureAssociation entities.
 * This interface provides methods for accessing and managing
 * the many-to-many relationship between guilds and features.
 */
@Repository
public interface GuildFeatureAssociationRepository extends JpaRepository<GuildFeatureAssociation, Long> {

    /**
     * Retrieves all feature IDs associated with a specific guild ID.
     *
     * @param id the ID of the guild
     * @return an Optional containing a Collection of feature IDs
     */
    @Query("SELECT gfa.featureId FROM GuildFeatureAssociation gfa WHERE guildId = :id")
    Optional<Collection<Integer>> findAllFeatureIdsByGuildId(@Param("id")Long id);

    /**
     * Retrieves all guild IDs associated with a specific feature ID.
     *
     * @param id the ID of the feature
     * @return an Optional containing a Collection of guild IDs
     */
    @Query("SELECT gfa.guildId FROM GuildFeatureAssociation gfa WHERE featureId = :id")
    Optional<Collection<Long>> findAllGuildIdsByFeatureId(@Param("id")Integer id);
}

