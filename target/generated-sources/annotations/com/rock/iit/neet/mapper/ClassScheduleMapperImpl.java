package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dao.ClassSchedule;
import com.rock.iit.neet.entity.dto.request.ClassScheduleRequestDTO;
import com.rock.iit.neet.entity.dto.response.ClassScheduleResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-30T16:52:28+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ClassScheduleMapperImpl implements ClassScheduleMapper {

    @Override
    public ClassSchedule toEntity(ClassScheduleRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        ClassSchedule.ClassScheduleBuilder classSchedule = ClassSchedule.builder();

        classSchedule.teacherId( requestDTO.getTeacherId() );
        classSchedule.subject( requestDTO.getSubject() );
        classSchedule.topic( requestDTO.getTopic() );
        classSchedule.date( requestDTO.getDate() );
        classSchedule.time( requestDTO.getTime() );
        classSchedule.batchId( requestDTO.getBatchId() );
        classSchedule.room( requestDTO.getRoom() );

        return classSchedule.build();
    }

    @Override
    public ClassScheduleResponseDTO toResponseDTO(ClassSchedule entity) {
        if ( entity == null ) {
            return null;
        }

        ClassScheduleResponseDTO.ClassScheduleResponseDTOBuilder classScheduleResponseDTO = ClassScheduleResponseDTO.builder();

        classScheduleResponseDTO.teacherId( entity.getTeacherId() );
        classScheduleResponseDTO.id( entity.getId() );
        classScheduleResponseDTO.subject( entity.getSubject() );
        classScheduleResponseDTO.topic( entity.getTopic() );
        classScheduleResponseDTO.date( entity.getDate() );
        classScheduleResponseDTO.time( entity.getTime() );
        classScheduleResponseDTO.batchId( entity.getBatchId() );
        classScheduleResponseDTO.room( entity.getRoom() );
        classScheduleResponseDTO.createdAt( entity.getCreatedAt() );
        classScheduleResponseDTO.updatedAt( entity.getUpdatedAt() );

        return classScheduleResponseDTO.build();
    }

    @Override
    public void updateEntityFromDTO(ClassScheduleRequestDTO requestDTO, ClassSchedule entity) {
        if ( requestDTO == null ) {
            return;
        }

        entity.setTeacherId( requestDTO.getTeacherId() );
        entity.setSubject( requestDTO.getSubject() );
        entity.setTopic( requestDTO.getTopic() );
        entity.setDate( requestDTO.getDate() );
        entity.setTime( requestDTO.getTime() );
        entity.setBatchId( requestDTO.getBatchId() );
        entity.setRoom( requestDTO.getRoom() );
    }
}
