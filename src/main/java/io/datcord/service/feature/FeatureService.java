package io.datcord.service.feature;

import io.datcord.entity.feature.Feature;


/**
 * Interface representing a service for handling features.
 */
public interface FeatureService {

        /**
         * Reads a feature by its ID.
         *
         * @param id the ID of the feature to read
         * @return the {@link io.datcord.entity.feature.Feature} object corresponding to the ID
         */
        Feature readFeature(int id);

}
