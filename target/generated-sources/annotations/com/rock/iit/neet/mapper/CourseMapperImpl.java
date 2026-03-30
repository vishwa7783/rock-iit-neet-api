package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dao.Course;
import com.rock.iit.neet.entity.dto.request.CourseRequestDTO;
import com.rock.iit.neet.entity.dto.response.CourseResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-30T16:52:28+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course toEntity(CourseRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.title( requestDTO.getTitle() );
        course.subtitle( requestDTO.getSubtitle() );
        course.description( requestDTO.getDescription() );
        course.targetClasses( requestDTO.getTargetClasses() );

        return course.build();
    }

    @Override
    public CourseResponseDTO toResponseDTO(Course entity) {
        if ( entity == null ) {
            return null;
        }

        CourseResponseDTO.CourseResponseDTOBuilder courseResponseDTO = CourseResponseDTO.builder();

        courseResponseDTO.id( entity.getId() );
        courseResponseDTO.title( entity.getTitle() );
        courseResponseDTO.subtitle( entity.getSubtitle() );
        courseResponseDTO.description( entity.getDescription() );
        courseResponseDTO.targetClasses( entity.getTargetClasses() );
        courseResponseDTO.createdAt( entity.getCreatedAt() );
        courseResponseDTO.updatedAt( entity.getUpdatedAt() );

        return courseResponseDTO.build();
    }

    @Override
    public void updateEntityFromDTO(CourseRequestDTO requestDTO, Course entity) {
        if ( requestDTO == null ) {
            return;
        }

        entity.setTitle( requestDTO.getTitle() );
        entity.setSubtitle( requestDTO.getSubtitle() );
        entity.setDescription( requestDTO.getDescription() );
        entity.setTargetClasses( requestDTO.getTargetClasses() );
    }
}
