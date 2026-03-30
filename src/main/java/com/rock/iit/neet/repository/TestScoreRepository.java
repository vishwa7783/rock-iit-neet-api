package com.rock.iit.neet.repository;

import com.rock.iit.neet.entity.dao.TestScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TestScoreRepository extends JpaRepository<TestScore, Long> {
    List<TestScore> findByStudentId(UUID studentId);
}
