package br.com.brenoborges.course_company.modules.company.useCases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brenoborges.course_company.modules.company.dto.CourseDTO;
import br.com.brenoborges.course_company.modules.company.entities.CourseEntity;
import br.com.brenoborges.course_company.modules.company.repositories.CourseRepository;

@Service
public class ListCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> execute() {
        // Lista de cursos recebendo todas infos cadastradas vindo do JPA.
        List<CourseEntity> courses = this.courseRepository.findAll();

        // Get para mostrar os resultados encontrados no findAll().
        var coursesDTO = courses.stream()
                .map(course -> CourseDTO.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .category(course.getCategory())
                        .createdAt(course.getCreatedAt())
                        .updatedAt(course.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());

        return coursesDTO; // Retorna a lista com os cursos
    }
}
