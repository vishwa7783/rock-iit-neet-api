package com.rock.iit.neet.entity.dao;

import com.rock.iit.neet.entity.enums.AttendanceStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private java.util.UUID studentId;

    @Column(name = "class_schedule_id", nullable = false)
    private Long classScheduleId;

    @Column(name = "subject")
    private String subject;

    @Enumerated(EnumType.STRING)
    @Column(name = "attendance_status", nullable = false)
    @NotNull(message = "Status is required")
    private AttendanceStatus attendanceStatus;

    @Column(nullable = false)
    private LocalDate date;
}
