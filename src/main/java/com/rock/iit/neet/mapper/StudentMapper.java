package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dto.request.StudentRequestDTO;
import com.rock.iit.neet.entity.dto.response.StudentResponseDTO;
import com.rock.iit.neet.entity.dao.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    Student toEntity(StudentRequestDTO requestDTO);

    StudentResponseDTO toResponseDTO(Student entity);

    void updateEntityFromDTO(StudentRequestDTO requestDTO, @MappingTarget Student entity);
}
