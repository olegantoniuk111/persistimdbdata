package ua.vin.persistimdbdata.controllers;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
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

    @Value("${rest.api.url}")
    private String url;

    private StringBuilder urlBuilder;

    public String getUrl() {
        return urlBuilder.toString();
    }

@GetMapping(value = "/persistImdbDataToDb", params = {"t","y"})

    public String getImdbData(@RequestParam (value = "t", required = false) String type,
                                          @RequestParam(value = "y") int year){
        urlBuilder = new StringBuilder(url);

    if (!type.isEmpty()){
        urlBuilder.append("&t="+type);
    }urlBuilder.append("&y="+year);
     executeJob();
    return "done";
}


private void executeJob() {
    try {
        jobLauncher.run(job, new JobParametersBuilder().addLong("startTime", System.currentTimeMillis()).toJobParameters());
    } catch (JobExecutionAlreadyRunningException e) {
        e.printStackTrace();
    } catch (JobRestartException e) {
        e.printStackTrace();
    } catch (JobInstanceAlreadyCompleteException e) {
        e.printStackTrace();
    } catch (JobParametersInvalidException e) {
        e.printStackTrace();
    }


}


}
