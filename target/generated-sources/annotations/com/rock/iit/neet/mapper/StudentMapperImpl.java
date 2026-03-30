package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dao.Student;
import com.rock.iit.neet.entity.dto.request.StudentRequestDTO;
import com.rock.iit.neet.entity.dto.response.StudentResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-30T16:52:28+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.name( requestDTO.getName() );
        student.email( requestDTO.getEmail() );
        student.phone( requestDTO.getPhone() );
        student.courseId( requestDTO.getCourseId() );
        student.batchId( requestDTO.getBatchId() );
        student.attendancePercentage( requestDTO.getAttendancePercentage() );

        return student.build();
    }

    @Override
    public StudentResponseDTO toResponseDTO(Student entity) {
        if ( entity == null ) {
            return null;
        }

        StudentResponseDTO.StudentResponseDTOBuilder studentResponseDTO = StudentResponseDTO.builder();

        studentResponseDTO.id( entity.getId() );
        studentResponseDTO.name( entity.getName() );
        studentResponseDTO.email( entity.getEmail() );
        studentResponseDTO.phone( entity.getPhone() );
        studentResponseDTO.courseId( entity.getCourseId() );
        studentResponseDTO.batchId( entity.getBatchId() );
        studentResponseDTO.attendancePercentage( entity.getAttendancePercentage() );
        studentResponseDTO.createdAt( entity.getCreatedAt() );
        studentResponseDTO.updatedAt( entity.getUpdatedAt() );

        return studentResponseDTO.build();
    }

    @Override
    public void updateEntityFromDTO(StudentRequestDTO requestDTO, Student entity) {
        if ( requestDTO == null ) {
            return;
        }

        entity.setName( requestDTO.getName() );
        entity.setEmail( requestDTO.getEmail() );
        entity.setPhone( requestDTO.getPhone() );
        entity.setCourseId( requestDTO.getCourseId() );
        entity.setBatchId( requestDTO.getBatchId() );
        entity.setAttendancePercentage( requestDTO.getAttendancePercentage() );
    }
}
