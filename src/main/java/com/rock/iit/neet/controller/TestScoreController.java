package com.rock.iit.neet.controller;

import com.rock.iit.neet.entity.dto.response.ApiResponse;
import com.rock.iit.neet.entity.dto.request.TestScoreRequestDTO;
import com.rock.iit.neet.entity.dto.response.TestScoreResponseDTO;
import com.rock.iit.neet.service.TestScoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/test-scores")
@RequiredArgsConstructor
public class TestScoreController {

    private final TestScoreService testScoreService;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<ApiResponse<List<TestScoreResponseDTO>>> getScoresByStudent(@PathVariable UUID studentId) {
        List<TestScoreResponseDTO> scores = testScoreService.getScoresByStudent(studentId);
        return ResponseEntity.ok(ApiResponse.success(scores));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TestScoreResponseDTO>> createScore(
            @Valid @RequestBody TestScoreRequestDTO requestDTO) {
        TestScoreResponseDTO score = testScoreService.createScore(requestDTO);
        return ResponseEntity.status(201).body(ApiResponse.success(score));
    }
}
