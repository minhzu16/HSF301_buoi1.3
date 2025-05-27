package repository;

import entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobRepository {
    Optional<Job> findById(long id);
    List<Job> findAll();
    Job save(Job job);
    Boolean delete(Job job);
    List<Job> findByJobName(String jobName);
    List<Job> findAll(int pageIndex, int pageSize);
    Boolean udapte(Job job);

}
