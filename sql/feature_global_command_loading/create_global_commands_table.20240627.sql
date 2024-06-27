CREATE TABLE global_command (
    command_id INT NOT NULL,      -- ID of the command that is globally available
    FOREIGN KEY (command_id) REFERENCES command(id)  -- Foreign key constraint referencing the command table
);
