package com.maraquepo.edc.artist;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maraquepo.edc.performance.Performance;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist {
    protected Artist() {

    }
    @Id
    @SequenceGenerator(
            name = "artist_sequence",
            sequenceName = "artist_sequence",
            allocationSize = 1
    )
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Performance> performances = new ArrayList<>();

    public Artist(Integer id, String name, List<Performance> performances) {
        this.id = id;
        this.name = name;
        this.performances = performances;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(List<Performance> performances) {
        this.performances = performances;
    }

    public void addPerformance(Performance performance) {
        performances.add(performance);
    }

    public void removePerformance(Performance performance) {
        performances.remove(performance);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", performanceList=" + performances +
                '}';
    }
}
