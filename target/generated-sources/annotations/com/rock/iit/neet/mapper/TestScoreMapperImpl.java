package com.rock.iit.neet.mapper;

import com.rock.iit.neet.entity.dao.TestScore;
import com.rock.iit.neet.entity.dto.request.TestScoreRequestDTO;
import com.rock.iit.neet.entity.dto.response.TestScoreResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-30T16:52:28+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TestScoreMapperImpl implements TestScoreMapper {

    @Override
    public TestScore toEntity(TestScoreRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        TestScore.TestScoreBuilder testScore = TestScore.builder();

        testScore.studentId( requestDTO.getStudentId() );
        testScore.subject( requestDTO.getSubject() );
        testScore.score( requestDTO.getScore() );
        testScore.total( requestDTO.getTotal() );
        testScore.date( requestDTO.getDate() );

        return testScore.build();
    }

    @Override
    public TestScoreResponseDTO toResponseDTO(TestScore entity) {
        if ( entity == null ) {
            return null;
        }

        TestScoreResponseDTO.TestScoreResponseDTOBuilder testScoreResponseDTO = TestScoreResponseDTO.builder();

        testScoreResponseDTO.id( entity.getId() );
        testScoreResponseDTO.studentId( entity.getStudentId() );
        testScoreResponseDTO.subject( entity.getSubject() );
        testScoreResponseDTO.score( entity.getScore() );
        testScoreResponseDTO.total( entity.getTotal() );
        testScoreResponseDTO.date( entity.getDate() );
        testScoreResponseDTO.createdAt( entity.getCreatedAt() );
        testScoreResponseDTO.updatedAt( entity.getUpdatedAt() );

        return testScoreResponseDTO.build();
    }

    @Override
    public void updateEntityFromDTO(TestScoreRequestDTO requestDTO, TestScore entity) {
        if ( requestDTO == null ) {
            return;
        }

        entity.setStudentId( requestDTO.getStudentId() );
        entity.setSubject( requestDTO.getSubject() );
        entity.setScore( requestDTO.getScore() );
        entity.setTotal( requestDTO.getTotal() );
        entity.setDate( requestDTO.getDate() );
    }
}
