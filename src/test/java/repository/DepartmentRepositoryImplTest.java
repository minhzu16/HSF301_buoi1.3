package repository;

import entity.Department;
import entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class DepartmentRepositoryImplTest {

    @Test
    void findAll() {
    }

    @Test
    void save() {
        Department department = new Department();
        department.setName("IVS");
        department.setDescription("IVS Viet Nam");

        Employee employee = new Employee();
        employee.setId("E0010");
        employee.setFirstName("James");
        employee.setLastName("Brown");
        employee.setEmail("james.brown@gmail.com");
        employee.setHireDate(LocalDate.now());
        employee.setPhoneNumber("1234567890");
        employee.setDepartment(department);

        Employee employee2 = new Employee();
        employee2.setId("E2002");
        employee2.setFirstName("John");
        employee2.setLastName("Smith");
        employee2.setEmail("john.smith@gmail.com");
        employee2.setHireDate(LocalDate.now());
        employee2.setPhoneNumber("987654321");
        employee2.setDepartment(department);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        employees.add(employee2);

        department.setEmployees(employees);

        DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
        Optional<Department> actual = departmentRepository.save(department);

        System.out.println("actual: " + actual.get());
    }
}