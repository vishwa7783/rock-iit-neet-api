package com.rock.iit.neet.controller;

import com.rock.iit.neet.entity.dto.response.ApiResponse;
import com.rock.iit.neet.entity.dto.request.TeacherRequestDTO;
import com.rock.iit.neet.entity.dto.response.TeacherResponseDTO;
import com.rock.iit.neet.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TeacherResponseDTO>>> getAllTeachers() {
        List<TeacherResponseDTO> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(ApiResponse.success(teachers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherResponseDTO>> getTeacherById(@PathVariable UUID id) {
        TeacherResponseDTO teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(ApiResponse.success(teacher));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TeacherResponseDTO>> createTeacher(
            @Valid @RequestBody TeacherRequestDTO requestDTO) {
        TeacherResponseDTO teacher = teacherService.createTeacher(requestDTO);
        return ResponseEntity.status(201).body(ApiResponse.success(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherResponseDTO>> updateTeacher(@PathVariable UUID id,
            @Valid @RequestBody TeacherRequestDTO requestDTO) {
        TeacherResponseDTO teacher = teacherService.updateTeacher(id, requestDTO);
        return ResponseEntity.ok(ApiResponse.success(teacher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTeacher(@PathVariable UUID id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok(ApiResponse.success());
    }
}
