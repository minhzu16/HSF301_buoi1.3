package config;

import aspects.LoggingAspect;
import controller.JobController;
import entity.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import repository.JobRepository;
import repository.JobRepositoryImpl;
import service.JobService;
import service.JobServiceImpl;

import java.math.BigDecimal;

@Configuration // this is metadata class/file
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public JobService jobService() {
        JobServiceImpl jobService = new JobServiceImpl();
        jobService.setJobRepository(jobRepository());
        return jobService;
    }

    @Bean
    public JobController jobController() {
        JobController jobController = new JobController();
        jobController.setJobService(jobService());
        return jobController;
    }

    @Bean
    public JobRepository jobRepository() {
        // init data for attributes ( if needed )
        return new JobRepositoryImpl();
    }

    @Bean
    public Job job() {
        Job job = new Job();
        job.setId(1L);
        job.setMinSalary(new BigDecimal(2000));
        job.setMaxSalary(new BigDecimal(5000));
        job.setJobTitle("Java Developer");
        return new Job();
    }
    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}