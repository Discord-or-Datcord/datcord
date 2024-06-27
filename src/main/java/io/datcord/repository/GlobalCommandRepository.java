package io.datcord.repository;

import io.datcord.entity.command.GlobalCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



/**
 * Repository interface for managing global command entities in the database.
 */
@Repository
public interface GlobalCommandRepository extends JpaRepository<GlobalCommand, Integer> {

}

