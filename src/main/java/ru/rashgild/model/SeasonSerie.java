package ru.rashgild.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "season_series")
public class SeasonSerie extends AbstractReference {

    @Column(name = "description")
    private String description;

    @Column(name = "path")
    private String path;

    @OneToOne
    private FilmSeason season;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FilmSeason getSeason() {
        return season;
    }

    public void setSeason(FilmSeason season) {
        this.season = season;
    }
}
