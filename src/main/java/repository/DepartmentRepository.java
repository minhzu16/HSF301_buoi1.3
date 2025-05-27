package repository;

import entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    List<Department> findAll();
    Optional<Department> save(Department department);

}
