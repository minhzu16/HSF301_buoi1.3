package entity;

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

public class JobHistory {

    @EmbeddedId
    private JobHistoryIds ids;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id" , referencedColumnName = "id")
    private Department department;
}
