package ua.vin.persistimdbdata.controllers;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobLauncherController {

    @Autowired
    public JobLauncher jobLauncher;

    @Autowired
    public Job job;



@GetMapping(value = "/persistImdbDataToDb", params = {"s","type","y"})

    public String getImdbData(@RequestParam (value = "s") String s,
                              @RequestParam (value = "type") String type,
                              @RequestParam(value = "y") String y){

     executeJob(s,type, y);

     return "done";
}


private void executeJob(String s,String type, String y) {
    try {
        jobLauncher.run(job, new JobParametersBuilder()
                .addLong("jobId", System.currentTimeMillis())
                .addString("s", s)
                .addString("type", type)
                .addString("y", y)
                .toJobParameters());
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}
