package repository;

import entity.Job;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import utility.JpaUtil;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class JobRepositoryImpl implements JobRepository{
    @Override
    public Optional<Job> findById(long id) {
        try(EntityManager en = JpaUtil.getEntityManager();) {
            return Optional.ofNullable(en.find(Job.class,id));
        }

    }

    @Override
    public List<Job> findAll() {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            TypedQuery<Job> query = em.createQuery("FROM Job j", Job.class);
            return query.getResultList();
        }
    }

    @Override
    public Job save(Job job) {
        EntityTransaction entityTransaction = null;
        // Open a connection
        try (EntityManager entityManager = JpaUtil.getEntityManager()) {
            // Create a new transaction
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            // Save to DB
            entityManager.persist(job);

            entityTransaction.commit();

            return job;
            //

        } catch (Exception e) {
            if ((entityTransaction != null) && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }


    @Override
    public Boolean delete(Job job) {
        return null;
    }

    @Override
    public List<Job> findByJobName(String jobName) {
        try {
            EntityManager entityManager = JpaUtil.getEntityManager(); // kết nối vật lý đến db
            // JPA = Jakarta Persistence Query Language ( NOT Native SQL )
            // ko can tu khoa select
            // Truy van den ten class hoac ten thuoc tinh
            // Cac tu khoa select , from , order by , group by , ... giong native sql
            TypedQuery<Job> typedQuery = entityManager.createQuery("From Job j WHERE j.jobTitle LIKE : title ",Job.class);
            //WHERE job_title LIKE '%Java Dev%'
            typedQuery.setParameter("title", "%" + jobName + "%");

            return typedQuery.getResultList(); // executeQuery() , duyet resultSet
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Job> findAll(int pageIndex, int pageSize) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            TypedQuery<Job> typedQuery = em.createQuery("FROM Job j ORDER BY j.jobTitle ASC", Job.class);
            typedQuery.setFirstResult((pageIndex - 1) * pageSize);
            typedQuery.setMaxResults(pageSize);

            return typedQuery.getResultList();
        }
    }

    @Override
    public Boolean udapte(Job job) {
        return null;
    }
}
