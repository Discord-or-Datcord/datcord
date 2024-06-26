package io.datcord.entity.command;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

/**
 * Entity representing the association between a guild and a command.
 * This serves as the junction table for the many-to-many relationship
 * between guilds and commands in the Discord bot.
 */
@Entity
@Data
@ToString
//@Table(name = "guild_command_association")
public class GuildCommandAssociation {

    /**
     * Unique identifier for the association
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * ID of the guild
     */
    @Column(nullable = false)
    private Long guildId;
    /**
     * ID of the command
     */
    @Column(nullable = false)
    private Integer commandId;
}

