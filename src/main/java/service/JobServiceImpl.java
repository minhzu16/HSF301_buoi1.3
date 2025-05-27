package service;

import entity.Job;
import repository.JobRepository;
import repository.JobRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class JobServiceImpl implements JobService{
    private JobRepository jobRepository;

    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Optional<Job> findById(long id) {
        return jobRepository.findById(id);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public boolean delete(Job job) {
        return false;
    }

    @Override
    public List<Job> findByJobName(String jobName) {
        return null; // This method should be implemented to return jobs by name
    }

    @Override
    public List<Job> findAll(int pageIndex, int pageSize) {
        return jobRepository.findAll(pageIndex, pageSize);
    }
}
