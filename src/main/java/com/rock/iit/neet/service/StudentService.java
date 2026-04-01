package com.rock.iit.neet.service;

import com.rock.iit.neet.entity.dto.request.StudentRequestDTO;
import com.rock.iit.neet.entity.dto.response.StudentResponseDTO;
import com.rock.iit.neet.entity.dao.Student;
import com.rock.iit.neet.exception.ResourceNotFoundException;
import com.rock.iit.neet.mapper.StudentMapper;
import com.rock.iit.neet.repository.CourseRepository;
import com.rock.iit.neet.repository.StudentRepository;
import com.rock.iit.neet.repository.TeacherRepository;
import com.rock.iit.neet.repository.jdbc.StudentJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;
    private final StudentJdbcRepository studentJdbcRepository;

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDTO> getAllStudentsJdbc() {
        return studentJdbcRepository.getStudentCourseBatchDetails();
    }

    public StudentResponseDTO getStudentById(UUID id) {
        return studentRepository.findById(id)
                .map(studentMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
    }

    @Transactional
    public StudentResponseDTO createStudent(StudentRequestDTO requestDTO) {
        Student student = studentMapper.toEntity(requestDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponseDTO(savedStudent);
    }

    @Transactional
    public StudentResponseDTO updateStudent(UUID id, StudentRequestDTO requestDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));

        studentMapper.updateEntityFromDTO(requestDTO, student);
        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toResponseDTO(updatedStudent);
    }

    @Transactional
    public void deleteStudent(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
        student.setStatus("archived");
        studentRepository.save(student);
    }

    public Map<String, Object> getAdminStats() {
        long totalStudents = studentRepository.count();
        long totalTeachers = teacherRepository.count();
        long activeCourses = courseRepository.count();

        return Map.of(
                "totalStudents", totalStudents,
                "totalTeachers", totalTeachers,
                "activeCourses", activeCourses,
                "revenue", "12.5L");
    }
}
