package com.rock.iit.neet.entity.dto.response;

import com.rock.iit.neet.entity.dao.BaseEntity;
import com.rock.iit.neet.entity.dao.Batch;
import com.rock.iit.neet.entity.dao.Course;
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
    private String parentName;
    private String parentPhoneNumber;
    private CourseResponseDTO course;
    private BatchResponseDTO batch;
    private Double attendancePercentage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
