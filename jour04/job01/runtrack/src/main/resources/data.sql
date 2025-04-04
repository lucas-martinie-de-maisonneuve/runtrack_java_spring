DROP TABLE IF EXISTS dbuser;

CREATE TABLE dbuser (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  role VARCHAR(250) NOT NULL
);
INSERT INTO dbuser (username, password, role) VALUES
('user', '$2a$10$D1OZjF1T1aGcW9n7HzF3VuwndLDlnQF0sPi1u7Wg.zZoNmq8hCl7C', 'USER'),
('admin', '$2a$10$uBCXzq.3kCSAN14V/FZ3zRjXhiz11KvGfmkBxJ7z0eBo9xxa46bCu', 'ADMIN');
