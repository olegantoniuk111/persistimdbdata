package ua.vin.persistimdbdata.step;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterRead;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ua.vin.persistimdbdata.model.OmdbItem;
import ua.vin.persistimdbdata.model.Search;
import ua.vin.persistimdbdata.model.Season;

import java.util.LinkedList;
import java.util.List;


public class OmdbReader implements ItemReader <List<OmdbItem>> {
    @BeforeStep
    public void beforeStep(final StepExecution stepExecution) {
        JobParameters jobParameters = stepExecution.getJobParameters();
        this.s = jobParameters.getString("s");
        this.type = jobParameters.getString("type");
        this.y = jobParameters.getString("y");

    }

    private String s;
    private String type;
    private String y;

    private List<OmdbItem> omdbItems = new LinkedList<>();

    @Value("${getMoviesUrl}")
    private String MoviesUrl;

    @Value("${getEpisodes}")
    private String SeasonUrl;

    @Autowired
    public RestTemplate restTemplate;


    @Override
    public List<OmdbItem> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        String url = getMoviesUrl(s, type, y);
        ResponseEntity<Search> response = restTemplate.getForEntity(url, Search.class);
        if (omdbItems.size() == response.getBody().getSearch().size()
                && omdbItems.containsAll(response.getBody().getSearch()))
            return null;
        omdbItems = response.getBody().getSearch();
        return omdbItems;

    }

    @AfterRead
    public List<OmdbItem> getSeasons() {
        if (type.equals("movie")) {
            return omdbItems;
        } else return readAllSeasons();

    }


    private List<OmdbItem> readAllSeasons() {
        for (OmdbItem item : omdbItems) {
            String serialUrl = getSerialUrl(item.getImdbID());
            OmdbItem omdbItem = restTemplate.getForEntity(serialUrl, OmdbItem.class).getBody();
            if (omdbItem.getTotalSeasons() > 0) {
                List<Season> seasons = new LinkedList<>();
                for (int i = 1; i <= omdbItem.getTotalSeasons(); i++) {
                    String seasonUrl = getSeasonUrl(omdbItem.getImdbID(), i);
                    seasons.add(restTemplate.getForEntity(seasonUrl, Season.class).getBody());
                }
                item.setSeasons(seasons);
            }

        }
        return omdbItems;
    }

    private String getMoviesUrl(String s, String type, String y) {
        return MoviesUrl+"&"+"s="+s+"&"+"type="+type+"&"+"y="+y;
    }
    private String getSerialUrl(String id) {
        return SeasonUrl+"&"+"i="+id;
    }
    private String getSeasonUrl(String id, int seasonNumber) {
        return SeasonUrl+"&"+"i="+id+"&"+"Season="+seasonNumber;
    }
}
