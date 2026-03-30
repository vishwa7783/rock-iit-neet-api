package com.rock.iit.neet.entity.dao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(name = "total_marks", nullable = false)
    private Integer totalMarks;

    @Column(name = "test_date", nullable = false)
    private LocalDate testDate;

    @Column(name = "batch_id", nullable = false)
    private Long batchId;
}
