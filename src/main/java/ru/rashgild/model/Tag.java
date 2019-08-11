package ru.rashgild.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag extends AbstractReference {
}
