package ru.rashgild.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre extends AbstractReference {
}
