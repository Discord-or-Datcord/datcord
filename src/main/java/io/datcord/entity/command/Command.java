package io.datcord.entity.command;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

/**
 * Represents a command entity.
 */
@Entity
@Data
@ToString
public class Command {

    /**
     * The JSON representation of the command.
     */
    @Column(name = "command", nullable = false)
    private String commandJson;

    /**
     * The unique identifier for the command.
     *
     * @GeneratedValue is the strategy used for primary key incremenation
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
