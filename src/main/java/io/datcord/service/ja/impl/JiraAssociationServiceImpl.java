package io.datcord.service.ja.impl;

import io.datcord.dto.ja.JiraAssociationDto;
import io.datcord.entity.ja.JiraAssociation;
import io.datcord.entity.ja.JiraAssociationGuild;
import io.datcord.repository.ja.JiraAssociationRepository;
import io.datcord.service.ja.JiraAssociationGuildService;
import io.datcord.service.ja.JiraAssociationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class JiraAssociationServiceImpl implements JiraAssociationService {

    private static final Logger logger = LoggerFactory.getLogger(JiraAssociationServiceImpl.class);

    @Override
    public Collection<JiraAssociation> findAllAssociationsForAssignee(String assigneeName) {
        logger.info("Searching for all associations for assignee {}", assigneeName);
        final Collection<JiraAssociation> associations = jiraAssociationRepository.findByAssigneeName(assigneeName);
        logger.info("Found {} associations for assigneee {}", associations.size(), assigneeName);
        return associations;
    }

    @Override
    public Collection<JiraAssociation> findAllAssociationsForUserId(long userId) {
        logger.info("Searching for all associations for user {}", userId);
        final Collection<JiraAssociation> associations = jiraAssociationRepository.findByUserId(userId);
        logger.info("Found {} associations for user {}", associations.size(), userId);
        return associations;
    }

    @Override
    public JiraAssociation createJiraAssociation(JiraAssociationDto associationDto) {
        logger.info("Creating jira association {}", associationDto);
        JiraAssociation jiraAssociation = new JiraAssociation();

        jiraAssociation.setAssigneeName(associationDto.getAssigneeName());
        jiraAssociation.setUserId(associationDto.getUserId());

        JiraAssociationGuild jiraAssociationGuild = new JiraAssociationGuild();

        jiraAssociationGuild.setGuildId(associationDto.getGuildId());
        jiraAssociationGuild.setJiraAssociationId(jiraAssociation.getId());

        logger.info("Creating jira association {}", jiraAssociation);

        JiraAssociation savedAssociation = jiraAssociationRepository.save(jiraAssociation);

        return savedAssociation;
//        try {//We don't want to create guild association if we don't successfully create the association
//            JiraAssociation savedAssociation = jiraAssociationRepository.save(jiraAssociation);
//            jiraAssociationGuildService.createJiraAssociationForGuild(jiraAssociationGuild);
//            return savedAssociation;
//        } catch (DataIntegrityViolationException e) {
//            logger.error("Error creating jira association", e);
//            throw new DataIntegrityViolationException("Failed to create jira association");
//        }
    }

    @Override
    public void removeJiraAssociation(JiraAssociationDto associationDto) {
        logger.info("Removing jira association {}", associationDto);

        JiraAssociation jiraAssociation = new JiraAssociation();

        jiraAssociation.setAssigneeName(associationDto.getAssigneeName());
        jiraAssociation.setUserId(associationDto.getUserId());

        jiraAssociationRepository.delete(jiraAssociation);
    }

    @Override
    public JiraAssociationDto getJiraAssociation(String assigneeName, long guildId) {
        final Collection<Integer> jiraAssociationGuilds = jiraAssociationGuildService.findAllJiraAssociationsForGuildId(guildId);
        final JiraAssociationDto jiraAssociationDto = new JiraAssociationDto();

        if(!jiraAssociationGuilds.isEmpty()) {
            try {
                int associationId = jiraAssociationGuilds
                        .stream()
                        .filter(id ->  jiraAssociationRepository.findById(id).isPresent())
                        .findAny()
                        .orElseThrow(() -> new DataIntegrityViolationException("Could not find association for assignee " + assigneeName));
                JiraAssociation jiraAssociation = jiraAssociationRepository
                        .findByAssigneeName(assigneeName)
                        .stream().filter(association -> association.getId() == associationId)
                        .findAny()
                        .orElseThrow(() -> new DataIntegrityViolationException("Could not find association for guild " + guildId));
                jiraAssociationDto.setUserId(jiraAssociation.getUserId());
                jiraAssociationDto.setGuildId(guildId);
                jiraAssociationDto.setAssigneeName(assigneeName);
                return jiraAssociationDto;
            } catch (DataIntegrityViolationException e) {
                logger.warn("Error getting jira association", e);
            }
        }

        return null;
    }

    private final JiraAssociationRepository jiraAssociationRepository;
    private final JiraAssociationGuildService jiraAssociationGuildService;
}
