package ua.vin.persistimdbdata.step;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ua.vin.persistimdbdata.controllers.JobLauncherController;
import ua.vin.persistimdbdata.model.OmdbUnit;


public class OmdbReader implements ItemReader <OmdbUnit> {

    private String unitID="";

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    JobLauncherController controller;

    @Override
    public OmdbUnit read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        String urlstr = controller.getUrl();
        ResponseEntity<OmdbUnit> omdbUnit = restTemplate.getForEntity(urlstr, OmdbUnit.class);
        OmdbUnit unit = omdbUnit.getBody();
        if(unitID.equals(unit.getImdbID())){
            return null;
        }
        unitID = unit.getImdbID();
            return unit;
    }


}
