CREATE TABLE broadcast
(
    broadcast_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name         VARCHAR(255),
    description  VARCHAR(255),
    started_at   TIMESTAMP,
    ended_at     TIMESTAMP,
    created_at   TIMESTAMP,
    modified_at  TIMESTAMP,
    status       VARCHAR(50),
    viewer_count INT
);

INSERT INTO broadcast(name, description, started_at, ended_at, created_at, modified_at, status, viewer_count) VALUES ('first', 'test', null, null, now(), now(), 'READY', 0);
INSERT INTO broadcast(name, description, started_at, ended_at, created_at, modified_at, status, viewer_count) VALUES ('second', 'yongjoon straming', null, null, now(), now(), 'READY', 0);
INSERT INTO broadcast(name, description, started_at, ended_at, created_at, modified_at, status, viewer_count) VALUES ('third', 'gaming streaming', null, null, now(), now(), 'READY', 0);