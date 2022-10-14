CREATE DATABASE  IF NOT EXISTS `cinema`;
USE `cinema`;

--
-- Table structure for table `halls`
--

DROP TABLE IF EXISTS halls;

CREATE TABLE halls (
  id int NOT NULL AUTO_INCREMENT,
  hall_name varchar(64) NOT NULL,
  comments varchar(128) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `halls`
--

INSERT INTO halls VALUES (1,'Hall1','30 seats');
INSERT INTO halls VALUES (2,'Hall2','60 seats');

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS movies;
CREATE TABLE movies (
  id int NOT NULL AUTO_INCREMENT,
  title varchar(128) NOT NULL,
  duration int NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `movies`
--

INSERT INTO movies VALUES (1,'Movie1',60);
INSERT INTO movies VALUES (2,'Movie2',90);
INSERT INTO movies VALUES (3,'Movie3',120);
INSERT INTO movies VALUES (4,'Movie4',90);

--
-- Table structure for table `prices`
--

DROP TABLE IF EXISTS prices;
CREATE TABLE prices (
  id int NOT NULL AUTO_INCREMENT,
  session_id int NOT NULL,
  price decimal(5,2) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  KEY fk_prices_sessions_idx (session_id),
  CONSTRAINT fk_prices_sessions FOREIGN KEY (session_id) REFERENCES sessions (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `prices`
--

INSERT INTO prices VALUES (2,1,150.00);
INSERT INTO prices VALUES (3,2,200.00);
INSERT INTO prices VALUES (4,3,350.00);
INSERT INTO prices VALUES (5,4,420.00);

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS seats;
CREATE TABLE seats (
  id int NOT NULL AUTO_INCREMENT,
  hall_id int NOT NULL,
  row_num int NOT NULL,
  seat_num int NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  KEY fk_seats_halls_idx (hall_id),
  CONSTRAINT fk_seats_halls FOREIGN KEY (hall_id) REFERENCES halls (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `seats`
--

INSERT INTO seats VALUES (1,1,1,2);
INSERT INTO seats VALUES (2,1,1,3);
INSERT INTO seats VALUES (3,1,1,4);
INSERT INTO seats VALUES (4,2,2,1);
INSERT INTO seats VALUES (5,2,2,1);
INSERT INTO seats VALUES (6,2,2,1);

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS sessions;
CREATE TABLE sessions (
  id int NOT NULL AUTO_INCREMENT,
  movie_id int NOT NULL,
  hall_id int NOT NULL,
  session_date date NOT NULL,
  session_time time NOT NULL,
  PRIMARY KEY (id),
  KEY fk_sessions_halls_idx (hall_id),
  KEY fk_sessions_movies_idx (movie_id),
  CONSTRAINT fk_sessions_halls FOREIGN KEY (hall_id) REFERENCES halls (id),
  CONSTRAINT fk_sessions_movies FOREIGN KEY (movie_id) REFERENCES movies (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sessions`
--

INSERT INTO sessions VALUES (1,1,1,'2022-10-12','10:00:00');
INSERT INTO sessions VALUES (2,2,2,'2022-10-12','12:00:00');
INSERT INTO sessions VALUES (3,3,1,'2022-10-12','12:00:00');
INSERT INTO sessions VALUES (4,4,2,'2022-10-12','13:00:00');

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS tickets;
CREATE TABLE tickets (
  id int NOT NULL AUTO_INCREMENT,
  session_id int NOT NULL,
  seat_id int NOT NULL,
  sold_out tinyint DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  KEY fk_tickets_sessions_idx (session_id),
  KEY fk_tickets_seats_idx (seat_id),
  CONSTRAINT fk_tickets_seats FOREIGN KEY (seat_id) REFERENCES seats (id),
  CONSTRAINT fk_tickets_sessions FOREIGN KEY (session_id) REFERENCES sessions (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tickets`
--

INSERT INTO tickets VALUES (1,1,1,1);
INSERT INTO tickets VALUES (2,2,2,1);
INSERT INTO tickets VALUES (3,1,3,1);
INSERT INTO tickets VALUES (4,3,4,1);

-- Dump completed
