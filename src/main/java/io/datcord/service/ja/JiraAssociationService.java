package io.datcord.service.ja;

import io.datcord.dto.ja.JiraAssociationDto;
import io.datcord.entity.ja.JiraAssociation;

import java.util.Collection;

/**
 * JiraAssociationService is an interface that provides methods to retrieve Jira associations based on assignees and user IDs.
 */
public interface JiraAssociationService {

    /**
     * Retrieves all associations for a given assignee.
     *
     * @param assigneeName the name of the assignee
     * @return a collection of JiraAssociation objects representing the associations for the assignee
     */
    Collection<JiraAssociation> findAllAssociationsForAssignee(String assigneeName);

    /**
     * Retrieves all associations for a given user ID.
     *
     * @param userId the unique identifier of the user
     * @return a collection of JiraAssociation objects representing the associations for the user
     */
    Collection<JiraAssociation> findAllAssociationsForUserId(long userId);

    /**
     * Creates a new JiraAssociation.
     *
     * @param associationDto the JiraAssociationDto object to be created
     */
    JiraAssociation createJiraAssociation(JiraAssociationDto associationDto);

    /**
     * Removes the given Jira association.
     *
     * @param associationDto the JiraAssociationDto to be removed
     */
    void removeJiraAssociation(JiraAssociationDto associationDto);

    /**
     * Retrieves the Jira association for the given user ID and guild ID.
     *
     * @param assigneeName    the assignee's name
     * @param guildId   the unique identifier of the guild
     * @return the JiraAssociationDto representing the Jira association for the user and guild
     */
    JiraAssociationDto getJiraAssociation(String assigneeName, long guildId);

}
