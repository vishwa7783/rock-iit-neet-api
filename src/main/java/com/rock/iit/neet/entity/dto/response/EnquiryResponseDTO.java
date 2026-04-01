package com.rock.iit.neet.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String interestedIn;
    private String schoolName;
    private String grade;
    private String parentName;
    private String parentPhoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private String reason;
}
