package com.rock.iit.neet.repository;

import com.rock.iit.neet.entity.dao.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {

    List<ClassSchedule> findByTeacherId(UUID teacherId);
}
