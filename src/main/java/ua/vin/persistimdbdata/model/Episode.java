package ua.vin.persistimdbdata.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "episode")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode implements Serializable {


    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Released")
    private String Released;
    @JsonProperty("Episode")
    private int Episode;
    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("imdbID")
    private String imdbID;

    @ManyToOne
    @JoinColumn(name = "Season")
    private Season season;

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Episode() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode = (Episode) o;
        return Episode == episode.Episode &&
                imdbRating == episode.imdbRating &&
                Objects.equals(Title, episode.Title) &&
                Objects.equals(Released, episode.Released) &&
                Objects.equals(imdbID, episode.imdbID) &&
                Objects.equals(season, episode.season);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Title, Released, Episode, imdbRating, imdbID, season);
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public int getEpisode() {
        return Episode;
    }

    public void setEpisode(int episode) {
        Episode = episode;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}



