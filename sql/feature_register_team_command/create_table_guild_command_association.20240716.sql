CREATE TABLE guild_command_association
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    guild_id   BIGINT NOT NULL,
    command_id INT    NOT NULL
);

