package io.datcord.repository.command;

import io.datcord.entity.command.GuildCommandAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * Repository interface for GuildCommandAssociation entities.
 * This interface provides methods for accessing and managing
 * the many-to-many relationship between guilds and commands.
 */
@Repository
public interface GuildCommandAssociationRepository extends JpaRepository<GuildCommandAssociation, Long> {

    /**
     * Retrieves all command IDs associated with a specific guild ID.
     *
     * @param id the ID of the guild
     * @return an Optional containing a Collection of command IDs
     */
    @Query("SELECT gca.commandId FROM GuildCommandAssociation gca WHERE guildId = :id")
    Optional<Collection<Integer>> findAllCommandIdsByGuildId(@Param("id")Long id);

    /**
     * Retrieves all guild IDs associated with a specific command ID.
     *
     * @param id the ID of the command
     * @return an Optional containing a Collection of guild IDs
     */
    @Query("SELECT gca.guildId FROM GuildCommandAssociation gca WHERE commandId = :id")
    Optional<Collection<Long>> findAllGuildIdsByCommandId(@Param("id")Integer id);
}

