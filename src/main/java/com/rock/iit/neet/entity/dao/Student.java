package com.rock.iit.neet.entity.dao;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "batch_id")
    private Long batchId;

    @Column(name = "attendance_percentage")
    private Double attendancePercentage;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "parent_phone_number")
    private String parentPhoneNumber;
}
