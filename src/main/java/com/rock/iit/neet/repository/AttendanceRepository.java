package com.rock.iit.neet.repository;

import com.rock.iit.neet.entity.dao.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(UUID studentId);

    List<Attendance> findByClassScheduleId(Long classScheduleId);
}
