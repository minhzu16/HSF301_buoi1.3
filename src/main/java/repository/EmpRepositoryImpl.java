package repository;

import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utility.JpaUtil;

import java.util.List;
import java.util.Optional;

public class EmpRepositoryImpl implements EmpRepository{
    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public List<Employee> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Employee> save (Employee employee) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = JpaUtil.getEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            return Optional.of(employee);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
        return Optional.empty();
    }
}
