package com.rock.iit.neet.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {
    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private String targetClasses;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
