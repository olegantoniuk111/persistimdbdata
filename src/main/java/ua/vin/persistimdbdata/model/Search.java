package ua.vin.persistimdbdata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Search implements Serializable {

    @JsonProperty("Search")
    private List<OmdbItem> Search;
    @JsonProperty("totalResults")
    private int totalResults;
    @JsonProperty("Response")
    private boolean Response;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ua.vin.persistimdbdata.model.Search that = (ua.vin.persistimdbdata.model.Search) o;
        return totalResults == that.totalResults &&
                Response == that.Response &&
                Objects.equals(Search, that.Search);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Search, totalResults, Response);
    }

    public List<OmdbItem> getSearch() {
        return Search;
    }

    public void setSearch(List<OmdbItem> search) {
        Search = search;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public boolean isResponse() {
        return Response;
    }

    public void setResponse(boolean response) {
        Response = response;
    }

    public Search() {
    }
}
