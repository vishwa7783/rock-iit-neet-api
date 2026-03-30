package com.rock.iit.neet.service;

import com.rock.iit.neet.entity.dto.request.AttendanceRequestDTO;
import com.rock.iit.neet.entity.dto.response.AttendanceResponseDTO;
import com.rock.iit.neet.entity.dao.Attendance;
import com.rock.iit.neet.entity.dao.Student;
import com.rock.iit.neet.entity.dao.ClassSchedule;
import com.rock.iit.neet.exception.ResourceNotFoundException;
import com.rock.iit.neet.mapper.AttendanceMapper;
import com.rock.iit.neet.repository.AttendanceRepository;
import com.rock.iit.neet.repository.StudentRepository;
import com.rock.iit.neet.repository.ClassScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final ClassScheduleRepository classScheduleRepository;
    private final AttendanceMapper attendanceMapper;

    public List<AttendanceResponseDTO> getAttendanceByStudent(UUID studentId) {
        return attendanceRepository.findByStudentId(studentId).stream()
                .map(attendance -> {
                    AttendanceResponseDTO dto = attendanceMapper.toResponseDTO(attendance);
                    studentRepository.findById(attendance.getStudentId())
                            .ifPresent(student -> dto.setStudentName(student.getName()));
                    classScheduleRepository.findById(attendance.getClassScheduleId())
                            .ifPresent(schedule -> dto.setSubject(schedule.getSubject()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<AttendanceResponseDTO> getAttendanceByClass(Long classId) {
        return attendanceRepository.findByClassScheduleId(classId).stream()
                .map(attendance -> {
                    AttendanceResponseDTO dto = attendanceMapper.toResponseDTO(attendance);
                    studentRepository.findById(attendance.getStudentId())
                            .ifPresent(student -> dto.setStudentName(student.getName()));
                    classScheduleRepository.findById(attendance.getClassScheduleId())
                            .ifPresent(schedule -> dto.setSubject(schedule.getSubject()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public AttendanceResponseDTO markAttendance(AttendanceRequestDTO requestDTO) {
        Student student = studentRepository.findById(requestDTO.getStudentId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Student not found with ID: " + requestDTO.getStudentId()));

        ClassSchedule schedule = classScheduleRepository.findById(requestDTO.getClassScheduleId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Class schedule not found with ID: " + requestDTO.getClassScheduleId()));

        Attendance attendance = attendanceMapper.toEntity(requestDTO);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        AttendanceResponseDTO dto = attendanceMapper.toResponseDTO(savedAttendance);
        dto.setStudentName(student.getName());
        dto.setSubject(schedule.getSubject());
        return dto;
    }
}
