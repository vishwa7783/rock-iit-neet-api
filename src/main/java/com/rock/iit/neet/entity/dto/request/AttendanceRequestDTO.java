package com.rock.iit.neet.entity.dto.request;

import com.rock.iit.neet.entity.enums.AttendanceStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRequestDTO {

    @NotNull(message = "Student ID is required")
    private UUID studentId;

    @NotNull(message = "Class schedule ID is required")
    private Long classScheduleId;

    @NotNull(message = "Date is required")
    private LocalDate date;
}
