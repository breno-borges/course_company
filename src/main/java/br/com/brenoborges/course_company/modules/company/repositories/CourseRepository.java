package br.com.brenoborges.course_company.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brenoborges.course_company.modules.company.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    // Procura no banco (Select) se já existe o curso e a categoria
    Optional<CourseEntity> findByNameAndCategory(String name, String category);

}
