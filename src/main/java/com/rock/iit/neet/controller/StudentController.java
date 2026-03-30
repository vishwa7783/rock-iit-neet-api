package com.rock.iit.neet.controller;

import com.rock.iit.neet.entity.dto.response.ApiResponse;
import com.rock.iit.neet.entity.dto.request.StudentRequestDTO;
import com.rock.iit.neet.entity.dto.response.StudentResponseDTO;
import com.rock.iit.neet.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponseDTO>>> getAllStudents() {
        List<StudentResponseDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(ApiResponse.success(students, "Students retrieved successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDTO>> getStudentById(@PathVariable UUID id) {
        StudentResponseDTO student = studentService.getStudentById(id);
        return ResponseEntity.ok(ApiResponse.success(student, "Student retrieved successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponseDTO>> createStudent(
            @Valid @RequestBody StudentRequestDTO requestDTO) {
        StudentResponseDTO student = studentService.createStudent(requestDTO);
        return ResponseEntity.status(201).body(ApiResponse.success(student, "Student created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDTO>> updateStudent(@PathVariable UUID id,
            @Valid @RequestBody StudentRequestDTO requestDTO) {
        StudentResponseDTO student = studentService.updateStudent(id, requestDTO);
        return ResponseEntity.ok(ApiResponse.success(student, "Student updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(ApiResponse.success("Student deleted successfully"));
    }

    @GetMapping("/admin/stats")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAdminStats() {
        Map<String, Object> stats = studentService.getAdminStats();
        return ResponseEntity.ok(ApiResponse.success(stats, "Admin statistics retrieved successfully"));
    }
}
