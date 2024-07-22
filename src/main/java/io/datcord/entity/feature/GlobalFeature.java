package io.datcord.entity.feature;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

/**
 * Represents a global feature entity.
 */
@Entity
@Data
@ToString
public class GlobalFeature {

    /**
     * The unique identifier for the global feature
     */
    @Id
    private int featureId;
}

