package io.datcord.repository;

import io.datcord.entity.feature.GlobalFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository interface for managing global feature entities in the database.
 */
@Repository
public interface GlobalFeatureRepository extends JpaRepository<GlobalFeature, Integer> {

}

