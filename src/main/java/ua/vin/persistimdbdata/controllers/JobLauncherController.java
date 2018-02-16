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

@GetMapping(value = "/persistImdbDataToDb", params = {"s","type","y"})

    public String getImdbData(@RequestParam (value = "s") String s,
                              @RequestParam (value = "type") String type,
                              @RequestParam(value = "y") String y){

JobExecution execution = null;
    try {
      execution =   executeJob(s,type, y);
    } catch (Exception e) {
        e.printStackTrace();
    }
    if(execution.getStatus().isUnsuccessful()){
        return "notDone";
    }return "done";

}


    private synchronized JobExecution executeJob(String s,String type, String y) throws Exception {
            return jobLauncher.run(job, new JobParametersBuilder()
                .addLong("jobId", System.currentTimeMillis())
                .addString("s", s)
                .addString("type", type)
                .addString("y", y)
                .toJobParameters());
        }
}

