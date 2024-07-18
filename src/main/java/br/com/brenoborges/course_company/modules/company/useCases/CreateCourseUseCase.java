package br.com.brenoborges.course_company.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brenoborges.course_company.exceptions.NameAndCategoryFoundException;
import br.com.brenoborges.course_company.modules.company.entities.CourseEntity;
import br.com.brenoborges.course_company.modules.company.repositories.CourseRepository;

@Service // Gerencia o ciclo desse UseCase
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        this.courseRepository.findByNameAndCategory(courseEntity.getName(), courseEntity.getCategory())
                // Verifica se o nome está presente na consulta e lança a mensagem de erro que
                // foi criada no pacote de Exceptions
                .ifPresent((name) -> {
                    throw new NameAndCategoryFoundException();
                });

        return this.courseRepository.save(courseEntity); // Retorna o objeto salvo pela propriedade do JPA
    }
}
