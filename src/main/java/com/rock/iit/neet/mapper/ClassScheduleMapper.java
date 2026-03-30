package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dto.request.ClassScheduleRequestDTO;
import com.rock.iit.neet.entity.dto.response.ClassScheduleResponseDTO;
import com.rock.iit.neet.entity.dao.ClassSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassScheduleMapper {

    @Mapping(target = "teacherId", source = "teacherId")
    ClassSchedule toEntity(ClassScheduleRequestDTO requestDTO);

    @Mapping(target = "teacherId", source = "teacherId")
    ClassScheduleResponseDTO toResponseDTO(ClassSchedule entity);

    @Mapping(target = "teacherId", source = "teacherId")
    void updateEntityFromDTO(ClassScheduleRequestDTO requestDTO, @MappingTarget ClassSchedule entity);
}
