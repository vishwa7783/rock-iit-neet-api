package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dto.request.AttendanceRequestDTO;
import com.rock.iit.neet.entity.dto.response.AttendanceResponseDTO;
import com.rock.iit.neet.entity.dao.Attendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AttendanceMapper {

    Attendance toEntity(AttendanceRequestDTO requestDTO);

    AttendanceResponseDTO toResponseDTO(Attendance entity);

    void updateEntityFromDTO(AttendanceRequestDTO requestDTO, @MappingTarget Attendance entity);
}
