package io.datcord.entity.command;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

/**
 * Represents a global command entity.
 */
@Entity
@Data
@ToString
public class GlobalCommand {

    /**
     * The unique identifier for the global command.
     */
    @Id
    private int commandId;
}

