CREATE TABLE film_roles (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  film_id INTEGER,
  actor_id INTEGER,
  roles_id INTEGER,
  CONSTRAINT film_id_ref FOREIGN KEY (film_id) REFERENCES FILMS(id),
  CONSTRAINT roles_id_ref FOREIGN KEY (roles_id) REFERENCES ROLES(id),
  CONSTRAINT actor_id_ref FOREIGN KEY (actor_id) REFERENCES ACTORS(id)
);
