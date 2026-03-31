package com.rock.iit.neet.service;

import com.rock.iit.neet.entity.dto.request.ClassScheduleRequestDTO;
import com.rock.iit.neet.entity.dto.response.ClassScheduleResponseDTO;
import com.rock.iit.neet.entity.dao.ClassSchedule;
import com.rock.iit.neet.entity.dao.Teacher;
import com.rock.iit.neet.exception.ResourceNotFoundException;
import com.rock.iit.neet.mapper.ClassScheduleMapper;
import com.rock.iit.neet.repository.ClassScheduleRepository;
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
public class ClassScheduleService {

    private final ClassScheduleRepository classScheduleRepository;
    private final TeacherRepository teacherRepository;
    private final ClassScheduleMapper classScheduleMapper;

    public List<ClassScheduleResponseDTO> getAllSchedules() {
        return classScheduleRepository.findAll().stream()
                .map(schedule -> {
                    ClassScheduleResponseDTO dto = classScheduleMapper.toResponseDTO(schedule);
                    teacherRepository.findById(schedule.getTeacherId())
                            .ifPresent(teacher -> dto.setTeacherName(teacher.getName()));
                    return dto;
                })
                .collect(Collectors.toList());
    }


    public List<ClassScheduleResponseDTO> getSchedulesByTeacher(UUID teacherId) {
        return classScheduleRepository.findByTeacherId(teacherId).stream()
                .map(schedule -> {
                    ClassScheduleResponseDTO dto = classScheduleMapper.toResponseDTO(schedule);
                    teacherRepository.findById(schedule.getTeacherId())
                            .ifPresent(teacher -> dto.setTeacherName(teacher.getName()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public ClassScheduleResponseDTO getScheduleById(Long id) {
        ClassSchedule schedule = classScheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class schedule not found with ID: " + id));
        ClassScheduleResponseDTO dto = classScheduleMapper.toResponseDTO(schedule);
        teacherRepository.findById(schedule.getTeacherId())
                .ifPresent(teacher -> dto.setTeacherName(teacher.getName()));
        return dto;
    }

    @Transactional
    public ClassScheduleResponseDTO createSchedule(ClassScheduleRequestDTO requestDTO) {
        Teacher teacher = teacherRepository.findById(requestDTO.getTeacherId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Teacher not found with ID: " + requestDTO.getTeacherId()));

        ClassSchedule schedule = classScheduleMapper.toEntity(requestDTO);
        ClassSchedule savedSchedule = classScheduleRepository.save(schedule);
        ClassScheduleResponseDTO dto = classScheduleMapper.toResponseDTO(savedSchedule);
        dto.setTeacherName(teacher.getName());
        return dto;
    }

    @Transactional
    public ClassScheduleResponseDTO updateSchedule(Long id, ClassScheduleRequestDTO requestDTO) {
        ClassSchedule schedule = classScheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class schedule not found with ID: " + id));

        Teacher teacher = teacherRepository.findById(requestDTO.getTeacherId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Teacher not found with ID: " + requestDTO.getTeacherId()));

        classScheduleMapper.updateEntityFromDTO(requestDTO, schedule);
        ClassSchedule updatedSchedule = classScheduleRepository.save(schedule);
        ClassScheduleResponseDTO dto = classScheduleMapper.toResponseDTO(updatedSchedule);
        dto.setTeacherName(teacher.getName());
        return dto;
    }

    @Transactional
    public void deleteSchedule(Long id) {
        if (!classScheduleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Class schedule not found with ID: " + id);
        }
        classScheduleRepository.deleteById(id);
    }
}
