package br.com.brenoborges.course_company.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.brenoborges.course_company.modules.company.dto.CourseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Gera o Id no BD
    private UUID id;

    private String name;
    private String category;

    // Se o curso estiver ativo recebe 1, se estiver inativo recebe 0.
    private byte active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Construtor que recebe os dados do body que vão para a DTO e seta eles nas
    // variáveis da entidade.
    public CourseEntity(CourseDTO courseDTO) {
        this.name = courseDTO.name();
        this.category = courseDTO.category();
        this.active = courseDTO.active();
    }
}
