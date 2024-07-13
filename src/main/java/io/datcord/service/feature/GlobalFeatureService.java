package io.datcord.service.feature;

import io.datcord.entity.feature.GlobalFeature;

import java.util.Collection;


/**
 * Interface representing a service for handling global features.
 */
public interface GlobalFeatureService {

        /**
         * Reads all features in the table
         * @return a collection of every {@link GlobalFeature} in the table
         */
        Collection<GlobalFeature> readAllGlobalFeatures();



}
