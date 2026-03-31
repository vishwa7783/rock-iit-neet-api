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

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<ApiResponse<List<EnquiryResponseDTO>>> getEnquiries(
            @RequestParam(required = false) List<String> statuses) {
        if (statuses == null || statuses.isEmpty()) {
            statuses = List.of("active");
        }
        List<EnquiryResponseDTO> activeEnquiries = enquiryService.getEnquiriesByStatuses(statuses);
        return ResponseEntity.ok(ApiResponse.success(activeEnquiries, "Enquiries fetched successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateEnquiryStatus(
            @PathVariable UUID id,
            @RequestBody Map<String, String> request) {
        String status = request.get("status");
        String reason = request.get("reason");
        if (status == null || status.trim().isEmpty()) {
            return new ResponseEntity<>(ApiResponse.error("Status is required"), HttpStatus.BAD_REQUEST);
        }
        if (reason == null || reason.trim().isEmpty()) {
            return new ResponseEntity<>(ApiResponse.error("Reason is required"), HttpStatus.BAD_REQUEST);
        }
        EnquiryResponseDTO updated = enquiryService.updateEnquiryStatus(id, status, reason);
        return ResponseEntity.ok(ApiResponse.success(updated, "Enquiry status updated successfully"));
    }
}
