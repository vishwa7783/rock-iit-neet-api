package com.rock.iit.neet.service;

import com.rock.iit.neet.entity.dto.request.EnquiryRequestDTO;
import com.rock.iit.neet.entity.dto.response.EnquiryResponseDTO;
import com.rock.iit.neet.entity.dao.Enquiry;
import com.rock.iit.neet.mapper.EnquiryMapper;
import com.rock.iit.neet.repository.EnquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnquiryService {
    private final EnquiryRepository enquiryRepository;
    private final EnquiryMapper enquiryMapper;

    @Transactional
    public EnquiryResponseDTO createEnquiry(EnquiryRequestDTO requestDTO) {
        Enquiry enquiry = enquiryMapper.toEntity(requestDTO);
        enquiry.setStatus("active");
        Enquiry saved = enquiryRepository.save(enquiry);
        return enquiryMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<EnquiryResponseDTO> getEnquiriesByStatuses(List<String> statuses) {
        return enquiryRepository.findAllByStatusInOrderByCreatedAtDesc(statuses)
                .stream()
                .map(enquiryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public EnquiryResponseDTO updateEnquiryStatus(UUID id, String status, String reason) {
        Enquiry enquiry = enquiryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enquiry not found"));
        enquiry.setStatus(status);
        enquiry.setReason(reason);
        Enquiry saved = enquiryRepository.save(enquiry);
        return enquiryMapper.toResponseDTO(saved);
    }
}
