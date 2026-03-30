package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dao.Attendance;
import com.rock.iit.neet.entity.dto.request.AttendanceRequestDTO;
import com.rock.iit.neet.entity.dto.response.AttendanceResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-30T16:52:28+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AttendanceMapperImpl implements AttendanceMapper {

    @Override
    public Attendance toEntity(AttendanceRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Attendance.AttendanceBuilder attendance = Attendance.builder();

        attendance.studentId( requestDTO.getStudentId() );
        attendance.classScheduleId( requestDTO.getClassScheduleId() );
        attendance.status( requestDTO.getStatus() );
        attendance.date( requestDTO.getDate() );

        return attendance.build();
    }

    @Override
    public AttendanceResponseDTO toResponseDTO(Attendance entity) {
        if ( entity == null ) {
            return null;
        }

        AttendanceResponseDTO.AttendanceResponseDTOBuilder attendanceResponseDTO = AttendanceResponseDTO.builder();

        attendanceResponseDTO.id( entity.getId() );
        attendanceResponseDTO.studentId( entity.getStudentId() );
        attendanceResponseDTO.classScheduleId( entity.getClassScheduleId() );
        attendanceResponseDTO.status( entity.getStatus() );
        attendanceResponseDTO.date( entity.getDate() );
        attendanceResponseDTO.createdAt( entity.getCreatedAt() );
        attendanceResponseDTO.updatedAt( entity.getUpdatedAt() );

        return attendanceResponseDTO.build();
    }

    @Override
    public void updateEntityFromDTO(AttendanceRequestDTO requestDTO, Attendance entity) {
        if ( requestDTO == null ) {
            return;
        }

        entity.setStudentId( requestDTO.getStudentId() );
        entity.setClassScheduleId( requestDTO.getClassScheduleId() );
        entity.setStatus( requestDTO.getStatus() );
        entity.setDate( requestDTO.getDate() );
    }
}
