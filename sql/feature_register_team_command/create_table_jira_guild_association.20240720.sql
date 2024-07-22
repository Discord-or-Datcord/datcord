CREATE TABLE jira_association_guild
(
    id                  SERIAL PRIMARY KEY,
    guild_id            BIGINT NOT NULL,
    jira_association_id INT    NOT NULL,
    CONSTRAINT fk_jira_association
        FOREIGN KEY (jira_association_id)
            REFERENCES jira_association (id)
);

