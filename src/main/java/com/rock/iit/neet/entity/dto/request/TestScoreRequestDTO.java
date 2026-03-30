package com.rock.iit.neet.entity.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class TestScoreRequestDTO {

    @NotNull(message = "Student ID is required")
    private UUID studentId;

    @NotBlank(message = "Subject is required")
    private String subject;

    @NotNull(message = "Score is required")
    @Positive(message = "Score must be positive")
    private Integer score;

    @NotNull(message = "Total is required")
    @Positive(message = "Total must be positive")
    private Integer total;

    @NotNull(message = "Date is required")
    private LocalDate date;
}
