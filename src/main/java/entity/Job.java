package entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "job", schema = "hr")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"employees", "jobHistories"})

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name = "job_Title" , columnDefinition = "NVARCHAR(255)" ,nullable = false)
    private String jobTitle; // camoCase

    @Column(name = "min_Salary", columnDefinition = "DECIMAL" , precision = 14 , scale = 2)
    private BigDecimal minSalary;
    @Column(name = "max_Salary", columnDefinition = "DECIMAL" , precision = 14 , scale = 2)
    private BigDecimal maxSalary;

    @OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
    private Set<Employee> employees ;

    @OneToMany(mappedBy = "job")
    private Set<JobHistory> jobHistories;

}
