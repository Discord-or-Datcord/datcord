package io.datcord.repository.ja;

import io.datcord.entity.ja.JiraAssociationGuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * The JiraAssociationGuildRepository interface is a repository that provides CRUD operations for the JiraAssociationGuild entity.
 * It extends the JpaRepository interface, which provides generic methods for interacting with the database.
 *
 * This repository is responsible for retrieving Jira association IDs for a given guild ID.
 *
 */
@Repository
public interface JiraAssociationGuildRepository extends JpaRepository<JiraAssociationGuild,Integer> {


    /**
     * Retrieves a collection of Jira association IDs for a given guild ID.
     *
     * @param guildId the ID of the guild to retrieve associations for
     * @return a collection of JiraAssociationGuild objects representing the associations for the guild
     */
    @Query("SELECT jag.jiraAssociationId FROM JiraAssociationGuild jag WHERE guildId = :id")
    Collection<Integer> findAllAssociationsForGuild(@Param("id") long guildId);
}
