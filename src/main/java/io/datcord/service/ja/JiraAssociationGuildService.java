package io.datcord.service.ja;

import io.datcord.entity.ja.JiraAssociationGuild;

import java.util.Collection;

/**
 * JiraAssociationGuildService interface represents a service that handles Jira associations for a guild.
 * This interface provides methods to retrieve Jira associations for a specific guild.
 * Implementation of this interface should be capable of interacting with the underlying database and retrieve the required data.
 */
public interface JiraAssociationGuildService {

    /**
     * Retrieves all Jira associations for a given guild ID.
     *
     * @param guildId the ID of the guild
     * @return a collection of JiraAssociationGuild objects representing the Jira associations for the guild
     */
    Collection<Integer> findAllJiraAssociationsForGuildId(long guildId);

    /**
     * Creates a new JiraAssociationGuild object and associates it with a JiraAssociation.
     *
     * @param jiraAssociationGuild the JiraAssociationGuild object to be created
     * @return the created JiraAssociationGuild object
     */
    JiraAssociationGuild createJiraAssociationForGuild(JiraAssociationGuild jiraAssociationGuild);
}
