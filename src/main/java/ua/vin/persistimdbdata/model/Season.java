package ua.vin.persistimdbdata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "seasons")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Season implements Serializable {
    public Season() {
    }


    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Season")
    private int Season;
    @JsonProperty("totalSeasons")
    private int totalSeasons;

    @OneToMany(mappedBy = "season")
    @JsonProperty("Episodes")
    private List<Episode> Episodes;

    @JsonProperty("Response")
    private boolean Response;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="imdbID" )
    private OmdbItem omdbItem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return Season == season.Season &&
                totalSeasons == season.totalSeasons &&
                Response == season.Response &&
                Objects.equals(Title, season.Title) &&
                Objects.equals(omdbItem, season.omdbItem) &&
                Objects.equals(Episodes, season.Episodes);
    }

    @Override
    public int hashCode() {

        return Objects.hash( Title, Season, totalSeasons, omdbItem, Episodes, Response);
    }



    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getSeason() {
        return Season;
    }

    public void setSeason(int season) {
        Season = season;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public OmdbItem getOmdbItem() {
        return omdbItem;
    }

    public void setOmdbItem(OmdbItem omdbItem) {
        this.omdbItem = omdbItem;
    }

    public List<Episode> getEpisodes() {
        return Episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.Episodes = episodes;
    }

    public boolean isResponse() {
        return Response;
    }

    public void setResponse(boolean response) {
        Response = response;
    }
}