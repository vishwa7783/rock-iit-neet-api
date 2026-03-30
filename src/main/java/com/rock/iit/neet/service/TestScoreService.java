package com.rock.iit.neet.service;

import com.rock.iit.neet.entity.dto.request.TestScoreRequestDTO;
import com.rock.iit.neet.entity.dto.response.TestScoreResponseDTO;
import com.rock.iit.neet.entity.dao.TestScore;
import com.rock.iit.neet.entity.dao.Student;
import com.rock.iit.neet.exception.ResourceNotFoundException;
import com.rock.iit.neet.mapper.TestScoreMapper;
import com.rock.iit.neet.repository.TestScoreRepository;
import com.rock.iit.neet.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestScoreService {

    private final TestScoreRepository testScoreRepository;
    private final StudentRepository studentRepository;
    private final TestScoreMapper testScoreMapper;

    public List<TestScoreResponseDTO> getScoresByStudent(UUID studentId) {
        return testScoreRepository.findByStudentId(studentId).stream()
                .map(score -> {
                    TestScoreResponseDTO dto = testScoreMapper.toResponseDTO(score);
                    studentRepository.findById(score.getStudentId())
                            .ifPresent(student -> dto.setStudentName(student.getName()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public TestScoreResponseDTO createScore(TestScoreRequestDTO requestDTO) {
        Student student = studentRepository.findById(requestDTO.getStudentId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Student not found with ID: " + requestDTO.getStudentId()));

        TestScore testScore = testScoreMapper.toEntity(requestDTO);

        TestScore savedScore = testScoreRepository.save(testScore);
        TestScoreResponseDTO dto = testScoreMapper.toResponseDTO(savedScore);
        dto.setStudentName(student.getName());
        return dto;
    }
}
