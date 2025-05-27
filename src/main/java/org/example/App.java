package org.example;

import config.AppConfig;
import controller.JobController;
import entity.Job;
import repository.JobRepository;
import repository.JobRepositoryImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Job job = new Job();
        job.setJobTitle("Java Developer");
        job.setMaxSalary(new BigDecimal(5000));
        job.setMinSalary(new BigDecimal(1000));

        JobRepository jobRepository = new JobRepositoryImpl();
//        System.out.println(jobRepository.save(job));

        System.out.println(jobRepository.findById(2));

        //WebApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JobController jobController = (JobController) context.getBean("jobController");
        Job newJob = (Job) context.getBean("Job");


        Map<String,String> map = jobController.saveJob(newJob);
        System.out.println(map.get("message"));

        Optional<Job> result = jobController.getJobById(1L);
        if (result.isPresent()) {
            System.out.println("Job found: " + result.get());
        } else {
            System.out.println("Job not found");
        }
    }
}
