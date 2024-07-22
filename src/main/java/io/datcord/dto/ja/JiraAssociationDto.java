package io.datcord.dto.ja;

import lombok.Data;
import lombok.ToString;

/**
 * Represents a JIRA association DTO.
 *
 * <p>
 * The JiraAssociationDto class is a data transfer object that holds information about a JIRA association.
 * It consists of the assignee name and the user ID.
 * </p>
 *
 * <p>
 * The class provides getters and setters for both the assignee name and the user ID, allowing access to and modification of the data.
 * </p>
 *
 * @since <version>
 */
@Data
@ToString
public class JiraAssociationDto {

    private String assigneeName;
    private long userId;
    private long guildId;

}
