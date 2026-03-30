package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dto.request.TeacherRequestDTO;
import com.rock.iit.neet.entity.dto.response.TeacherResponseDTO;
import com.rock.iit.neet.entity.dao.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherMapper {

    Teacher toEntity(TeacherRequestDTO requestDTO);

    TeacherResponseDTO toResponseDTO(Teacher entity);

    void updateEntityFromDTO(TeacherRequestDTO requestDTO, @MappingTarget Teacher entity);
}
