package com.rock.iit.neet.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponseDTO {
    private UUID id;
    private String name;

    private String phone;
    private String email;
    private String recordStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String[] subjects;
}
