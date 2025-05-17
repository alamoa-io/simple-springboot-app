CREATE TABLE chat_histories (
                       id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       question TEXT,
                       answer TEXT,
                       memo TEXT
);