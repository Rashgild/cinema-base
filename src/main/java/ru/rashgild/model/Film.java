package ru.rashgild.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "films")
public class Film extends AbstractReference {

    @Column(name = "nameOriginal")
    private String nameOriginal;

    @Column(name = "country")
    private String country;

    @Column(name = "release")
    private LocalDate release;

    @Column(name = "time")
    private String time;

    @Column(name = "tv_series")
    private Boolean tvSeries;

    @Column(name = "photo")
    private String photo;

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(Boolean tvSeries) {
        this.tvSeries = tvSeries;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
