package repository;

import entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmpRepository {
    Employee getEmployeeById(Long id);
    List<Employee> findAll();
    List<Employee> findAll(int page, int size);
    Optional<Employee> save(Employee employee);
}
