package io.datcord.controller.ja;

import io.datcord.dto.ja.JiraAssociationDto;
import io.datcord.entity.ja.JiraAssociation;
import io.datcord.entity.ja.JiraAssociationGuild;
import io.datcord.service.ja.JiraAssociationGuildService;
import io.datcord.service.ja.JiraAssociationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/commands/jira")
@RequiredArgsConstructor
public class JiraAssociationController {

    private static final Logger logger = LoggerFactory.getLogger(JiraAssociationController.class);

    @PostMapping("/create")
    public ResponseEntity<HttpStatus>  saveJiraAssociation(@RequestBody JiraAssociationDto jiraAssociationDto) {
        logger.info("POST jira association {}", jiraAssociationDto);

        JiraAssociation jiraAssociation = jiraAssociationService.createJiraAssociation(jiraAssociationDto);

        JiraAssociationGuild jiraAssociationGuild = new JiraAssociationGuild();

        jiraAssociationGuild.setJiraAssociationId(jiraAssociation.getId());
        jiraAssociationGuild.setGuildId(jiraAssociationDto.getGuildId());

        jiraAssociationGuildService.createJiraAssociationForGuild(jiraAssociationGuild);

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping("/association")
    public ResponseEntity<JiraAssociationDto>  saveJiraAssociation(HttpServletResponse response, @RequestParam String assigneeName, @RequestParam long guildId) {
        logger.info("GET jira association for assignee [{}] guildId [{}]", assigneeName,guildId);

        JiraAssociationDto jiraAssociationDto = jiraAssociationService.getJiraAssociation(assigneeName,guildId);

        logger.info("Found association {}", jiraAssociationDto);

        return ResponseEntity.ok(jiraAssociationDto);
    }



    private final JiraAssociationService jiraAssociationService;
    private final JiraAssociationGuildService jiraAssociationGuildService;
}
