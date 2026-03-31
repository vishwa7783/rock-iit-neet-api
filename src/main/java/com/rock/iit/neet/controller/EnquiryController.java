package com.rock.iit.neet.controller;

import com.rock.iit.neet.entity.dto.request.EnquiryRequestDTO;
import com.rock.iit.neet.entity.dto.response.EnquiryResponseDTO;
import com.rock.iit.neet.entity.dto.response.ApiResponse;
import com.rock.iit.neet.service.EnquiryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enquiries")
@RequiredArgsConstructor
public class EnquiryController {
    private final EnquiryService enquiryService;

    @PostMapping
    public ResponseEntity<ApiResponse<EnquiryResponseDTO>> createEnquiry(
            @Valid @RequestBody EnquiryRequestDTO requestDTO) {
        EnquiryResponseDTO response = enquiryService.createEnquiry(requestDTO);
        return new ResponseEntity<>(ApiResponse.success(response, "Enquiry created successfully"), HttpStatus.CREATED);
    }
}
