package br.com.brenoborges.course_company.modules.company.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brenoborges.course_company.modules.company.entities.CourseEntity;
import br.com.brenoborges.course_company.modules.company.repositories.CourseRepository;

@Service
public class ListCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute() {
        // Lista de cursos recebendo todas infos cadastradas vindo do JPA.
        List<CourseEntity> courses = this.courseRepository.findAll();

        return courses; // Retorna a lista com os cursos
    }
}
