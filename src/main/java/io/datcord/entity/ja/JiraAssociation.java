package io.datcord.entity.ja;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

/**
 * JiraAssociation class represents an association entity in Jira.
 * This class is annotated with @Entity to indicate that it is an entity that can be persisted in a database.
 *
 * Properties:
 * - id: an integer representing the id of the JiraAssociation. It is annotated with @Id and @GeneratedValue to indicate that it is the primary key of the entity and its value is
 *  generated automatically.
 * - assigneeName: a string representing the name of the assignee associated with this JiraAssociation.
 * - userId: a long representing the unique identifier of the discord user associated with this JiraAssociation.
 *
 * Example usage:
 * JiraAssociation jiraAssociation = new JiraAssociation();
 * jiraAssociation.setAssigneeName("John Doe");
 * jiraAssociation.setUserId(1234567890);
 *
 * Note: This class does not contain any methods. It is used to represent the structure and attributes of a JiraAssociation entity.
 */
@Entity
@Data
@ToString
public class JiraAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String assigneeName;

    private long userId;
}
