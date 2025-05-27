package entity;

import entity.Department;
import entity.Job;
import entity.JobHistory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(schema = "hr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private String id;

    @Column(name = "first_name", nullable = false, columnDefinition = "NVARCHAR(255)")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "NVARCHAR(255)")
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name ="hire_date")
    private LocalDate hireDate;

    @Column(columnDefinition = "DECIMAL", precision = 12, scale = 2)
    private BigDecimal salary;

    @Column(name = "commission_pct")
    private BigDecimal commissionPct;

    @ManyToOne
    @JoinColumn(name = "job_id",
            referencedColumnName = "id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Employee employee;

    @OneToOne(mappedBy = "employee")
    private entity.Dependence dependence;

    @OneToOne(mappedBy = "manager")
    private Department deptManagement;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "ids.employee", cascade = CascadeType.ALL)
    private Set<JobHistory> jobHistories;

}
