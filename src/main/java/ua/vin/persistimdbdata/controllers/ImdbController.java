package ua.vin.persistimdbdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import java.util.Collection;

@Controller
public class ImdbController {
    @Autowired
    public RestTemplate restTemplate;

    private final String KEY = "apikey=PlzBanMe";
    private final String URL = "https://www.omdbapi.com/";



@GetMapping(value = "getImdbData" )
    public Collection<String> getImdbData(@RequestParam (value = "t", required = false) String type,
                                          @RequestParam(value = "y") int year
                                          ){


    return null;
}
}
