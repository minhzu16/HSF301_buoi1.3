package controller;

import entity.Job;
import service.JobService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JobController {
    private JobService jobService;

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public Map<String,String> saveJob(Job job){
        Job result = jobService.save(job);

        Map<String, String> map = new HashMap<>();
        if (result != null) {
            map.put("status", "success");
            map.put("message", "Job saved successfully");
        } else {
            map.put("status", "error");
            map.put("message", "Failed to save job");
        }
        return map;

    }

    public Optional<Job> getJobById(long id) {
        return jobService.findById(id);
    }
}
