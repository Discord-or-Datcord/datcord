-- creates a table with the name guild_feature_association with the columns id, guild_id, feature_id
-- id is a BIGINT (long) and can not be null
-- guild_id is a BIGINT (long) and can not be null
-- feature_id is a BIGINT (long) and can not be null
create table guild_feature_association
(
    id        BIGINT NOT NULL,
    guild_id   BIGINT NOT NULL,
    feature_id INT NOT NULL
);