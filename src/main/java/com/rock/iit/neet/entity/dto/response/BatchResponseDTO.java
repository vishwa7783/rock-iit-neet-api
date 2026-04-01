package com.rock.iit.neet.entity.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchResponseDTO {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
