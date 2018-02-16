package ua.vin.persistimdbdata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name ="omdb")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbItem implements Serializable {

    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Year")
    private String Year;

    @Id
    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Type")
    private String Type;
    @JsonProperty("Poster")
    private String Poster;

    @JsonProperty("totalSeasons")
    private int totalSeasons;

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    @OneToMany(mappedBy = "omdbItem", cascade = CascadeType.ALL)
    private List<Season> seasons;

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }


    public OmdbItem() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    @Override
    public String toString() {
        return "OmdbItem{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", Type='" + Type + '\'' +
                ", Poster='" + Poster + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmdbItem unit = (OmdbItem) o;
        return Objects.equals(Title, unit.Title) &&
                Objects.equals(Year, unit.Year) &&
                Objects.equals(imdbID, unit.imdbID) &&
                Objects.equals(Type, unit.Type) &&
                Objects.equals(Poster, unit.Poster);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Title, Year, imdbID, Type, Poster);
    }
}