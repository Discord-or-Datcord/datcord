package io.datcord.controller.feature;

import io.datcord.entity.feature.Feature;
import io.datcord.service.feature.FeatureService;
import io.datcord.service.feature.GuildFeatureAssociationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


/**
 * Controller class for handling guild feature associations.
 */
@RestController
@RequestMapping("api/v1/features")
@RequiredArgsConstructor
public class GuildFeatureAssociationController {

    /**
     * Logger instance for logging information related to guild feature associations.
     */
    private static final Logger logger = LoggerFactory.getLogger(GuildFeatureAssociationController.class);


    /**
     * Retrieves all features associated with a guild based on guild ID.
     *
     * @param response the HttpServletResponse
     * @param guildId  the ID of the guild
     * @return ResponseEntity containing a collection of Feature objects
     */
    @GetMapping("/guild")
    public ResponseEntity<Collection<Feature>> getAllCommandsForGuildId(HttpServletResponse response, @RequestParam long guildId) {
        logger.debug("Received request for all available features from guild {}", guildId);

        Collection<Feature> features = new ArrayList<>();
        Collection<Integer> availableFeatureIds = guildFeatureAssociationService.readAllFeatureIdForGuildId(guildId);

        availableFeatureIds.forEach(featureId -> {
            Feature feature = featureService.readFeature(featureId);
            logger.debug("Found feature {}", feature);
            if (feature != null) {
                logger.debug("Adding feature {}", feature);
                features.add(feature);
            }
        });

        logger.debug("Found {} available features for guild {}", availableFeatureIds.size(), guildId);
        logger.debug("Found {} actual features", features.size());

        return ResponseEntity.of(Optional.of(features));
    }

    /**
     * Service for managing guild command associations.
     */
    private final GuildFeatureAssociationService guildFeatureAssociationService;

    /**
     * Service for handling commands.
     */
    private final FeatureService featureService;
}
