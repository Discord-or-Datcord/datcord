package io.datcord.entity.ja;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

/**
* Represents the association between a {@link JiraAssociation} and a Discord guild
 * This is used to track how many associations any given guild has
 */
@Entity
@Data
@ToString
public class JiraAssociationGuild {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long guildId;

    private int jiraAssociationId;
}
