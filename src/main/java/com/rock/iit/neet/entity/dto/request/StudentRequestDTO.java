package com.rock.iit.neet.entity.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
    private String phone;

    @NotNull(message = "Course ID is required")
    private Long courseId;

    @NotNull(message = "Batch ID is required")
    private Long batchId;

    @Min(0)
    @Max(100)
    private Double attendancePercentage;
}
