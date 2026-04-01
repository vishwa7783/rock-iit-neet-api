package com.rock.iit.neet.service;

import com.rock.iit.neet.entity.dto.request.CourseRequestDTO;
import com.rock.iit.neet.entity.dto.response.CourseResponseDTO;
import com.rock.iit.neet.entity.dao.Course;
import com.rock.iit.neet.exception.ResourceNotFoundException;
import com.rock.iit.neet.mapper.CourseMapper;
import com.rock.iit.neet.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CourseResponseDTO getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
    }

    @Transactional
    public CourseResponseDTO createCourse(CourseRequestDTO requestDTO) {
        Course course = courseMapper.toEntity(requestDTO);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toResponseDTO(savedCourse);
    }

    @Transactional
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO requestDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));

        courseMapper.updateEntityFromDTO(requestDTO, course);
        Course updatedCourse = courseRepository.save(course);
        return courseMapper.toResponseDTO(updatedCourse);
    }

    @Transactional
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
        course.setStatus("archived");
        courseRepository.save(course);
    }
}
