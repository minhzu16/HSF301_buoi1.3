package entity;

import entity.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(schema = "hr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dependence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    @OneToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id", unique = true)
    private Employee employee;
}
