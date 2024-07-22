package io.datcord.service.feature.impl;

import io.datcord.entity.feature.Feature;
import io.datcord.repository.feature.FeatureRepository;
import io.datcord.service.feature.FeatureService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Implementation of {@link io.datcord.service.feature.FeatureService} that handles feature operations.
 */
@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    /**
     * Logger instance for logging information related to feature operations.
     */
    private static final Logger logger = LoggerFactory.getLogger(FeatureServiceImpl.class);

    /**
     * Retrieves a feature based on its ID.
     *
     * @param id the ID of the feature to retrieve
     * @return the Feature object corresponding to the ID, or null if not found
     */
    @Override
    public Feature readFeature(int id) {
        logger.debug("Reading feature {}", id);
        Feature feature = featureRepository.findById(id).orElse(null);

        if (feature == null) {
            logger.debug("No feature with id {} found", id);
        }

        return feature;
    }

    /**
     * Repository for accessing feature data.
     */
    private final FeatureRepository featureRepository;
}
