package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dto.request.EnquiryRequestDTO;
import com.rock.iit.neet.entity.dto.response.EnquiryResponseDTO;
import com.rock.iit.neet.entity.dao.Enquiry;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnquiryMapper {
    Enquiry toEntity(EnquiryRequestDTO requestDTO);

    EnquiryResponseDTO toResponseDTO(Enquiry entity);
}
