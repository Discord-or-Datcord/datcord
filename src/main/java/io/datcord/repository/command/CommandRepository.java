package io.datcord.repository.command;

import io.datcord.entity.command.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for performing CRUD operations on Command entities.
 *
 * Must be annotated with @Repository to represent this is a repository to the spring container
 * Must extend {@link JpaRepository} the first binding should be the entity stored in the repository
 * the 2nd binding should be the data type of the ID
 *
 *
 */
@Repository
public interface CommandRepository extends JpaRepository<Command, Integer> {

    /**
     * Finds a command by its ID.
     *
     * Use findByATTR for any attributes that exist in the entity class {@link Command}
     * EX* findById findByCommandJson
     *
     *
     * @param id The ID of the command to find.
     * @return An Optional containing the found command, or empty if not found.
     */
    Optional<Command> findById(int id);
}

