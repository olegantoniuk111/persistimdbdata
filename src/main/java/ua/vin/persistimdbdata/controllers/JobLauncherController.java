package ua.vin.persistimdbdata.controllers;

import org.springframework.batch.core.*;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.vin.persistimdbdata.step.OmdbRestReader;

@Controller
public class JobLauncherController {

    @Autowired
    public JobLauncher jobLauncher;

    @Autowired
    public Job job;

    private  StringBuilder url = new StringBuilder("https://www.omdbapi.com/?apikey=PlzBanMe");
    private String urlString;

    public String getUrlString() {
        return urlString;
    }





@GetMapping(value = "/persistImdbDataToDb", params = {"t","y","apikey"})
    public String getImdbData(@RequestParam (value = "t", required = false) String type,
                                          @RequestParam(value = "y") int year){

    if (!type.isEmpty()){
        url.append("&t="+type);
    }url.append("&y="+year);

    this.urlString = url.toString();

    return "done";
}


}
