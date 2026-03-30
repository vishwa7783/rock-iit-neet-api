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
public class StudentResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private Long courseId;
    private Long batchId;
    private Double attendancePercentage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
