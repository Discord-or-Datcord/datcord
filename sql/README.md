# SQL Folder

This directory contains SQL queries organized according to specific guidelines for our project.

## Guidelines for SQL Queries

1. **Single Query per File**: Each SQL query should be placed in its own `.sql` file.

2. **Rollback Files**: Every SQL query file must have a corresponding rollback file ending with `.rollback.sql`. This file should contain the SQL query to rollback the changes made by the main `.sql` file.

3. **File Naming Convention**:
    - SQL Query File: `QUERY_TYPE_name.DATE.sql` (e.g., `insert_test_example_global_command.20240627.sql`)
    - Rollback File: `QUERY_TYPE_name.DATE.sql.rollback` (e.g., `insert_test_example_global_command.20240627.sql.rollback`)

4. **Directory Structure**: SQL files should be organized within subdirectories named after the branch name they belong to.

## Example Usage

Suppose you have a SQL query to insert a global command:

### SQL Query File: `insert_test_example_global_command.20240627.sql`

```sql
-- SQL query to insert a global command
INSERT INTO global_commands (command_id)
VALUES (123);
```

### Rollback File: 
`insert_test_example_global_command.20240627.sql.rollback`

```sql
-- Rollback query to remove the inserted global command
DELETE FROM global_commands
WHERE command_id = 123;
```

### Directory Structure Example

Assuming your current branch name is develop, the structure would look like:

```
sql/
└── develop/
    ├── insert_test_example_global_command.20240627.sql
    └── insert_test_example_global_command.20240627.sql.rollback

```