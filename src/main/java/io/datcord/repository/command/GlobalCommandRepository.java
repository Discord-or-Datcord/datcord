package io.datcord.repository.command;

import io.datcord.entity.command.GlobalCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository interface for managing global command entities in the database.
 */
@Repository
public interface GlobalCommandRepository extends JpaRepository<GlobalCommand, Integer> {

}

