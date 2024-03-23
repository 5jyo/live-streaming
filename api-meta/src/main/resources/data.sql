CREATE TABLE broadcast
(
    broadcast_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255),
    description  VARCHAR(255),
    started_at   TIMESTAMP,
    ended_at     TIMESTAMP,
    created_at   TIMESTAMP,
    modified_at  TIMESTAMP,
    status       VARCHAR(50),
    viewer_count INT
);

INSERT INTO broadcast VALUES (1, 'first', 'test', null, null, now(), now(), 'READY', 0);
INSERT INTO broadcast VALUES (2, 'second', 'yongjoon straming', null, null, now(), now(), 'READY', 0);
INSERT INTO broadcast VALUES (3, 'third', 'gaming streaming', null, null, now(), now(), 'READY', 0);
