package repository;

import entity.Employee;
import entity.Job;
import entity.JobHistory;
import entity.JobHistoryIds;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class JobRepositoryImplTest {
    private static EmpRepository employeeRepository;

    @BeforeAll
    public static void setupBefore() {
        employeeRepository = new EmpRepositoryImpl();
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void save() {
        Employee employee = new Employee();
        employee.setId("E001");
        employee.setFirstName("Bui");
        employee.setLastName("Huy Hung");
        employee.setEmail("hung@gmail.com");
        employee.setHireDate(LocalDate.now());
        employee.setSalary(new BigDecimal(1000));

        Job job = new Job();
        job.setId(5l);

        employee.setJob(job);


        Optional<Employee> actual = employeeRepository.save(employee);
        assertEquals(employee, actual.get());

    }

    @Test
    void save2() {

        // Khởi tạo data
        Employee employee = new Employee();

        employee.setId("E003");
        employee.setFirstName("Nguyuen");
        employee.setLastName("Huy Hieu");
        employee.setEmail("hoa@gmail.com");
        employee.setHireDate(LocalDate.now());
        employee.setSalary(new BigDecimal(1000));

        // Khởi tạo JOb và set cho Employee
        Job job = new Job();
        job.setId(5l);
        employee.setJob(job);


        // Khởi tạo JObHistory và setter
        JobHistory jobHistory = new JobHistory();
        jobHistory.setJob(job);
        jobHistory.setIds(new JobHistoryIds(employee, LocalDate.now()));
        Set<JobHistory> jobHistorySet = new HashSet<>();
        jobHistorySet.add(jobHistory);

        employee.setJobHistories(jobHistorySet);

        Optional<Employee> actual = employeeRepository.save(employee);
        assertEquals(employee, actual.get());

    }
}