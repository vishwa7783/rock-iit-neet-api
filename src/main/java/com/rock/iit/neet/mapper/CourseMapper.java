package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dto.request.CourseRequestDTO;
import com.rock.iit.neet.entity.dto.response.CourseResponseDTO;
import com.rock.iit.neet.entity.dao.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

    Course toEntity(CourseRequestDTO requestDTO);

    CourseResponseDTO toResponseDTO(Course entity);

    void updateEntityFromDTO(CourseRequestDTO requestDTO, @MappingTarget Course entity);
}
