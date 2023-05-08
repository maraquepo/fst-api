package com.maraquepo.edc.performance;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.maraquepo.edc.artist.Artist;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Performance {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Artist artist;
    private PerformanceDay performanceDay;

    private Stages stages;
    private LocalTime startTime;
    private LocalTime endtime;

    public Performance() {

    }
    public Performance(Integer id, Artist artist, PerformanceDay performanceDay, Stages stages, LocalTime startTime, LocalTime endtime) {
        this.id = id;
        this.artist = artist;
        this.performanceDay = performanceDay;
        this.stages = stages;
        this.startTime = startTime;
        this.endtime = endtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public PerformanceDay getPerformanceDay() {
        return performanceDay;
    }

    public void setPerformanceDay(PerformanceDay performanceDay) {
        this.performanceDay = performanceDay;
    }

    public Stages getStages() {
        return stages;
    }

    public void setStages(Stages stages) {
        this.stages = stages;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id=" + id +
                ", artist=" + artist +
                ", performanceDay=" + performanceDay +
                ", stages=" + stages +
                ", startTime=" + startTime +
                ", endtime=" + endtime +
                '}';
    }
}
