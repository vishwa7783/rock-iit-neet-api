package com.rock.iit.neet.service;

import com.rock.iit.neet.entity.dto.request.EnquiryRequestDTO;
import com.rock.iit.neet.entity.dto.response.EnquiryResponseDTO;
import com.rock.iit.neet.entity.dao.Enquiry;
import com.rock.iit.neet.mapper.EnquiryMapper;
import com.rock.iit.neet.repository.EnquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnquiryService {
    private final EnquiryRepository enquiryRepository;
    private final EnquiryMapper enquiryMapper;

    @Transactional
    public EnquiryResponseDTO createEnquiry(EnquiryRequestDTO requestDTO) {
        Enquiry enquiry = enquiryMapper.toEntity(requestDTO);
        Enquiry saved = enquiryRepository.save(enquiry);
        return enquiryMapper.toResponseDTO(saved);
    }
}
