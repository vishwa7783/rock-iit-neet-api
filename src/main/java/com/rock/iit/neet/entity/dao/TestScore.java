package com.rock.iit.neet.entity.dao;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "test_scores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestScore extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private java.util.UUID studentId;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private Integer total;

    @Column(nullable = false)
    private LocalDate date;
}
