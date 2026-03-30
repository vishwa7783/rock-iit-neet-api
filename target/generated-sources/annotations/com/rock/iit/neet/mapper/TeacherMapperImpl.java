package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dao.Teacher;
import com.rock.iit.neet.entity.dto.request.TeacherRequestDTO;
import com.rock.iit.neet.entity.dto.response.TeacherResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-30T16:52:28+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public Teacher toEntity(TeacherRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Teacher.TeacherBuilder teacher = Teacher.builder();

        teacher.name( requestDTO.getName() );
        teacher.phone( requestDTO.getPhone() );
        teacher.email( requestDTO.getEmail() );

        return teacher.build();
    }

    @Override
    public TeacherResponseDTO toResponseDTO(Teacher entity) {
        if ( entity == null ) {
            return null;
        }

        TeacherResponseDTO.TeacherResponseDTOBuilder teacherResponseDTO = TeacherResponseDTO.builder();

        teacherResponseDTO.id( entity.getId() );
        teacherResponseDTO.name( entity.getName() );
        teacherResponseDTO.phone( entity.getPhone() );
        teacherResponseDTO.email( entity.getEmail() );
        teacherResponseDTO.createdAt( entity.getCreatedAt() );
        teacherResponseDTO.updatedAt( entity.getUpdatedAt() );

        return teacherResponseDTO.build();
    }

    @Override
    public void updateEntityFromDTO(TeacherRequestDTO requestDTO, Teacher entity) {
        if ( requestDTO == null ) {
            return;
        }

        entity.setName( requestDTO.getName() );
        entity.setPhone( requestDTO.getPhone() );
        entity.setEmail( requestDTO.getEmail() );
    }
}
