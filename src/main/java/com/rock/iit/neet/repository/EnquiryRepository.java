package com.rock.iit.neet.repository;

import com.rock.iit.neet.entity.dao.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, UUID> {
    Optional<Enquiry> findByEmail(String email);

    Optional<Enquiry> findByPhone(String phone);

    List<Enquiry> findAllByStatusOrderByCreatedAtDesc(String status);

    List<Enquiry> findAllByStatusInOrderByCreatedAtDesc(List<String> statuses);
}
