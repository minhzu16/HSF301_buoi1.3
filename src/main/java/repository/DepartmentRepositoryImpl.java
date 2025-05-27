package repository;

import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utility.JpaUtil;

import java.util.List;
import java.util.Optional;

public class DepartmentRepositoryImpl implements DepartmentRepository{
    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Optional<Department> save(Department department) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager= JpaUtil.getEntityManager();){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(department);
            entityTransaction.commit();

            return Optional.ofNullable(department);
        }catch (Exception e){
            if (entityTransaction != null) entityTransaction.rollback();
        }
        return Optional.empty();
    }
}
