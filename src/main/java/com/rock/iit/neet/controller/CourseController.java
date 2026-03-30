package com.rock.iit.neet.controller;

import com.rock.iit.neet.entity.dto.response.ApiResponse;
import com.rock.iit.neet.entity.dto.request.CourseRequestDTO;
import com.rock.iit.neet.entity.dto.response.CourseResponseDTO;
import com.rock.iit.neet.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponseDTO>>> getAllCourses() {
        List<CourseResponseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(ApiResponse.success(courses, "Courses retrieved successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> getCourseById(@PathVariable Long id) {
        CourseResponseDTO course = courseService.getCourseById(id);
        return ResponseEntity.ok(ApiResponse.success(course, "Course retrieved successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponseDTO>> createCourse(
            @Valid @RequestBody CourseRequestDTO requestDTO) {
        CourseResponseDTO course = courseService.createCourse(requestDTO);
        return ResponseEntity.status(201).body(ApiResponse.success(course, "Course created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> updateCourse(@PathVariable Long id,
            @Valid @RequestBody CourseRequestDTO requestDTO) {
        CourseResponseDTO course = courseService.updateCourse(id, requestDTO);
        return ResponseEntity.ok(ApiResponse.success(course, "Course updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(ApiResponse.success("Course deleted successfully"));
    }
}
