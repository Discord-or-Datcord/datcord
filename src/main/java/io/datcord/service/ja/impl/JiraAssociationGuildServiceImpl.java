package io.datcord.service.ja.impl;

import io.datcord.entity.ja.JiraAssociationGuild;
import io.datcord.repository.ja.JiraAssociationGuildRepository;
import io.datcord.service.ja.JiraAssociationGuildService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class JiraAssociationGuildServiceImpl implements JiraAssociationGuildService {

    private static final Logger logger = LoggerFactory.getLogger(JiraAssociationGuildServiceImpl.class);

    @Override
    public Collection<Integer> findAllJiraAssociationsForGuildId(long guildId) {
        logger.info("Finding all associations for guild id {}", guildId);
        Collection<Integer> jiraAssociationGuilds = jiraAssociationGuildRepository.findAllAssociationsForGuild(guildId);
        logger.info("Found {} associations for guild id {}", jiraAssociationGuilds.size(), guildId);

        return jiraAssociationGuilds;
    }

    @Override
    public JiraAssociationGuild createJiraAssociationForGuild(JiraAssociationGuild jag) {
        logger.info("Creating association for guild id {}", jag.getGuildId());
        return jiraAssociationGuildRepository.save(jag);
    }

    private final JiraAssociationGuildRepository jiraAssociationGuildRepository;
}
