package service;

import entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    Optional<Job> findById(long id);

    List<Job> findAll();

    Job save(Job job);

    boolean delete(Job job);

    List<Job> findByJobName(String jobName);

    List<Job> findAll(int pageIndex, int pageSize);
}
