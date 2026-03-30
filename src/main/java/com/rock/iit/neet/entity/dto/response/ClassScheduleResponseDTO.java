package com.rock.iit.neet.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassScheduleResponseDTO {
    private Long id;
    private String subject;
    private String topic;
    private LocalDate date;
    private LocalTime time;
    private UUID teacherId;
    private String teacherName;
    private Long batchId;
    private String room;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
