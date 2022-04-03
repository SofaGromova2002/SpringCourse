CREATE TABLE IF NOT EXISTS todo_list
(
    id    UUID PRIMARY KEY ,
    name  text NOT NULL
);

CREATE TABLE IF NOT EXISTS todo
(
    id    UUID PRIMARY KEY ,
    name  text NOT NULL,
    description  text NOT NULL,
    timestamp timestamptz NOT NULL,
    todo_list_id UUID NOT NULL,

    CONSTRAINT todo_foreign_key
    FOREIGN KEY(todo_list_id)
    REFERENCES todo_list(id)
);