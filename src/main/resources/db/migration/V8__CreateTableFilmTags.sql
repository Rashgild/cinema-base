CREATE TABLE film_tags (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  film_id INTEGER,
  tag_id INTEGER,
  CONSTRAINT film_id_ref3 FOREIGN KEY (film_id) REFERENCES FILMS(id),
  CONSTRAINT tag_id_ref FOREIGN KEY (tag_id) REFERENCES TAGS(id)
);
