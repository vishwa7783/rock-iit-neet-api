package com.rock.iit.neet.controller;

import com.rock.iit.neet.entity.dto.response.ApiResponse;
import com.rock.iit.neet.entity.dto.request.ClassScheduleRequestDTO;
import com.rock.iit.neet.entity.dto.response.ClassScheduleResponseDTO;
import com.rock.iit.neet.service.ClassScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ClassScheduleController {

    private final ClassScheduleService classScheduleService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ClassScheduleResponseDTO>>> getAllSchedules() {
        List<ClassScheduleResponseDTO> schedules = classScheduleService.getAllSchedules();
        return ResponseEntity.ok(ApiResponse.success(schedules, "Schedules retrieved successfully"));
    }

    @GetMapping("/batch/{batch}")
    public ResponseEntity<ApiResponse<List<ClassScheduleResponseDTO>>> getSchedulesByBatch(@PathVariable String batch) {
        List<ClassScheduleResponseDTO> schedules = classScheduleService.getSchedulesByBatch(batch);
        return ResponseEntity.ok(ApiResponse.success(schedules, "Batch schedules retrieved successfully"));
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<ApiResponse<List<ClassScheduleResponseDTO>>> getSchedulesByTeacher(
            @PathVariable UUID teacherId) {
        List<ClassScheduleResponseDTO> schedules = classScheduleService.getSchedulesByTeacher(teacherId);
        return ResponseEntity.ok(ApiResponse.success(schedules, "Teacher schedules retrieved successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClassScheduleResponseDTO>> getScheduleById(@PathVariable Long id) {
        ClassScheduleResponseDTO schedule = classScheduleService.getScheduleById(id);
        return ResponseEntity.ok(ApiResponse.success(schedule, "Schedule retrieved successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClassScheduleResponseDTO>> createSchedule(
            @Valid @RequestBody ClassScheduleRequestDTO requestDTO) {
        ClassScheduleResponseDTO schedule = classScheduleService.createSchedule(requestDTO);
        return ResponseEntity.status(201).body(ApiResponse.success(schedule, "Schedule created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ClassScheduleResponseDTO>> updateSchedule(@PathVariable Long id,
            @Valid @RequestBody ClassScheduleRequestDTO requestDTO) {
        ClassScheduleResponseDTO schedule = classScheduleService.updateSchedule(id, requestDTO);
        return ResponseEntity.ok(ApiResponse.success(schedule, "Schedule updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSchedule(@PathVariable Long id) {
        classScheduleService.deleteSchedule(id);
        return ResponseEntity.ok(ApiResponse.success("Schedule deleted successfully"));
    }
}
