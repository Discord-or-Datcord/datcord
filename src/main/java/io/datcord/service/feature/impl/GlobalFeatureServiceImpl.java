package io.datcord.service.feature.impl;

import io.datcord.entity.feature.GlobalFeature;
import io.datcord.repository.GlobalFeatureRepository;
import io.datcord.service.feature.GlobalFeatureService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * Implementation of {@link io.datcord.service.feature.GlobalFeatureService} that handles global feature operations.
 */
@Service
@RequiredArgsConstructor
public class GlobalFeatureServiceImpl implements GlobalFeatureService {

    /**
     * Logger instance for logging information related to feature operations.
     */
    private static final Logger logger = LoggerFactory.getLogger(GlobalFeatureServiceImpl.class);


    /**
     * Retrieves all features in the repository
     * @return a collection of every {@link io.datcord.entity.feature.GlobalFeature} in the repository
     */
    @Override
    public Collection<GlobalFeature> readAllGlobalFeatures() {
        logger.debug("Reading all global features");
        Collection<GlobalFeature> globalFeatures = featureRepository.findAll();
        logger.debug("Found {} global features",globalFeatures.size());
        return globalFeatures;
    }

    /**
     * Repository for accessing feature data.
     */
    private final GlobalFeatureRepository featureRepository;
}
