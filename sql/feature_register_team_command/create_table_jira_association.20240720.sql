CREATE TABLE jira_association
(
    id      INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    assignee_name VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL
);