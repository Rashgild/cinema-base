CREATE TABLE season_series (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  name VARCHAR,
  description VARCHAR,
  path VARCHAR,
  season_id INTEGER,
  CONSTRAINT season_id_ref FOREIGN KEY (season_id) REFERENCES FILM_SEASONS(id)
);