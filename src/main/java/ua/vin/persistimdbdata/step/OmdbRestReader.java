package ua.vin.persistimdbdata.step;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sun.net.www.protocol.http.HttpURLConnection;
import ua.vin.persistimdbdata.controllers.JobLauncherController;

import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class OmdbRestReader implements ItemReader <List<String>> {
    private List<String> data;
    public  String urlstr;
    private URL url;


    public OmdbRestReader() {
        data = new LinkedList<>();

    }


    @Override
    public List<String> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        URL url = new URL(urlstr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();
        if(responseCode!=200)
            throw new RuntimeException("HTTP Response code" + responseCode);
        else {
            Scanner scn = new Scanner(url.openStream());
            while (scn.hasNext()){
                data.add(scn.nextLine());
            }
            scn.close();
        }
        return data;
    }


}
