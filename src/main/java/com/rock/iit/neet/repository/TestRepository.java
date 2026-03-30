package com.rock.iit.neet.repository;

import com.rock.iit.neet.entity.dao.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
    List<TestEntity> findByBatchId(Long batchId);
}
