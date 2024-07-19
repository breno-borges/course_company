package br.com.brenoborges.course_company.modules.company.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private UUID id;
    private String name;
    private String category;
    private byte active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
