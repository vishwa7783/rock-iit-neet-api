package com.rock.iit.neet.service;

import com.rock.iit.neet.entity.dto.request.TeacherRequestDTO;
import com.rock.iit.neet.entity.dto.response.TeacherResponseDTO;
import com.rock.iit.neet.entity.dao.Teacher;
import com.rock.iit.neet.exception.ResourceNotFoundException;
import com.rock.iit.neet.mapper.TeacherMapper;
import com.rock.iit.neet.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    // We can't directly use ClassScheduleRepository here without potential circular
    // dependencies
    // if ClassScheduleService also uses TeacherService.
    // But for a foundation, we can use the repository directly or via a dedicated
    // schedule service.

    public List<TeacherResponseDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public TeacherResponseDTO getTeacherById(UUID id) {
        return teacherRepository.findById(id)
                .map(teacherMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with ID: " + id));
    }

    @Transactional
    public TeacherResponseDTO createTeacher(TeacherRequestDTO requestDTO) {
        Teacher teacher = teacherMapper.toEntity(requestDTO);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toResponseDTO(savedTeacher);
    }

    @Transactional
    public TeacherResponseDTO updateTeacher(UUID id, TeacherRequestDTO requestDTO) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with ID: " + id));

        teacherMapper.updateEntityFromDTO(requestDTO, teacher);
        Teacher updatedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toResponseDTO(updatedTeacher);
    }

    @Transactional
    public void deleteTeacher(UUID id) {
        if (!teacherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Teacher not found with ID: " + id);
        }
        teacherRepository.deleteById(id);
    }
}
