package com.rock.iit.neet.controller;

import com.rock.iit.neet.entity.dto.response.ApiResponse;
import com.rock.iit.neet.entity.dto.request.AttendanceRequestDTO;
import com.rock.iit.neet.entity.dto.response.AttendanceResponseDTO;
import com.rock.iit.neet.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attendances")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<ApiResponse<List<AttendanceResponseDTO>>> getAttendanceByStudent(
            @PathVariable UUID studentId) {
        List<AttendanceResponseDTO> attendance = attendanceService.getAttendanceByStudent(studentId);
        return ResponseEntity.ok(ApiResponse.success(attendance, "Student attendance retrieved successfully"));
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<ApiResponse<List<AttendanceResponseDTO>>> getAttendanceByClass(@PathVariable Long classId) {
        List<AttendanceResponseDTO> attendance = attendanceService.getAttendanceByClass(classId);
        return ResponseEntity.ok(ApiResponse.success(attendance, "Class attendance retrieved successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AttendanceResponseDTO>> markAttendance(
            @Valid @RequestBody AttendanceRequestDTO requestDTO) {
        AttendanceResponseDTO attendance = attendanceService.markAttendance(requestDTO);
        return ResponseEntity.status(201).body(ApiResponse.success(attendance, "Attendance marked successfully"));
    }
}
