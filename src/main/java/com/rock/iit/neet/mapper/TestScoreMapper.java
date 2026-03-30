package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dto.request.TestScoreRequestDTO;
import com.rock.iit.neet.entity.dto.response.TestScoreResponseDTO;
import com.rock.iit.neet.entity.dao.TestScore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestScoreMapper {

    TestScore toEntity(TestScoreRequestDTO requestDTO);

    TestScoreResponseDTO toResponseDTO(TestScore entity);

    void updateEntityFromDTO(TestScoreRequestDTO requestDTO, @MappingTarget TestScore entity);
}
