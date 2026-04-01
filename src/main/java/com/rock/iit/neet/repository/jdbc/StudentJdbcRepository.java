package com.rock.iit.neet.repository.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rock.iit.neet.entity.dto.response.BatchResponseDTO;
import com.rock.iit.neet.entity.dto.response.CourseResponseDTO;
import com.rock.iit.neet.entity.dto.response.StudentResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StudentJdbcRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public RowMapper<StudentResponseDTO> studentRowMapper() {
        return (rs, rowNum) -> {

            CourseResponseDTO course = new CourseResponseDTO();
            course.setTitle(rs.getString("course_title"));
            course.setSubtitle(rs.getString("subtitle"));
            course.setDescription(rs.getString("description"));
            course.setTargetClasses(rs.getString("target_classes"));
            course.setCreatedAt(Objects.isNull(rs.getTimestamp("course_created_at")) ? null : rs.getTimestamp("course_created_at").toLocalDateTime());
//            course.setUpdatedAt(rs.getTimestamp("course_updated_at").toLocalDateTime());

            BatchResponseDTO batch = new BatchResponseDTO();
            batch.setName(rs.getString("batch_name"));
            batch.setStartDate(rs.getDate("start_date").toLocalDate());
            batch.setEndDate(rs.getDate("end_date").toLocalDate());

            return StudentResponseDTO.builder()
                    .id(UUID.fromString(rs.getString("student_id")))
                    .name(rs.getString("student_name"))
                    .email(rs.getString("email"))
                    .phone(rs.getString("phone"))
                    .parentName(rs.getString("parent_name"))
                    .parentPhoneNumber(rs.getString("parent_phone_number"))
                    .attendancePercentage(rs.getDouble("attendance_percentage"))
                    .createdAt(Objects.isNull(rs.getTimestamp("student_created_at")) ?
                            null : rs.getTimestamp("student_created_at").toLocalDateTime())
                    .updatedAt(Objects.isNull(rs.getTimestamp("student_updated_at")) ?
                            null : rs.getTimestamp("student_updated_at").toLocalDateTime())
                    .course(course)
                    .batch(batch)
                    .build();
        };
    }

    public List<StudentResponseDTO> getStudentCourseBatchDetails() {

        String sql = """
          SELECT
             s.id AS student_id,
             s.name AS student_name,
             s.email,
             s.phone,
             s.parent_name,
             s.parent_phone_number,
             s.attendance_percentage,
             s.created_at AS student_created_at,
             s.updated_at AS student_updated_at,

             c.title AS course_title,
             c.subtitle,
             c.description,
             c.target_classes,
             c.created_at AS course_created_at,

             b.name AS batch_name,
             b.start_date,
             b.end_date

         FROM students s
         JOIN courses c ON s.course_id = c.id
         JOIN batches b ON s.batch_id = b.id
    """;

        return namedParameterJdbcTemplate.query(sql, studentRowMapper());
    }
}
