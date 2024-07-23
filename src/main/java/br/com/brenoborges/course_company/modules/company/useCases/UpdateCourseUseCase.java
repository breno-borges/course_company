package br.com.brenoborges.course_company.modules.company.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brenoborges.course_company.exceptions.IdNotFoundException;
import br.com.brenoborges.course_company.exceptions.NameAndCategoryFoundException;
import br.com.brenoborges.course_company.modules.company.dto.CourseDTO;
import br.com.brenoborges.course_company.modules.company.entities.CourseEntity;
import br.com.brenoborges.course_company.modules.company.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity put(UUID id, CourseDTO courseDTO) {

        // Verifica a validade do Id
        CourseEntity courseEntity = this.courseRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException());

        // Verifica se o valor existe, se sim true, se não, false.
        boolean nameAndCategoryInUse = this.courseRepository
                .findByNameAndCategory(courseDTO.name(), courseDTO.category())
                .isPresent();

        if (nameAndCategoryInUse) { // Se existe nome e categoria, lança a tratativa.
            throw new NameAndCategoryFoundException();
        }

        courseEntity.setName(courseDTO.name());
        courseEntity.setCategory(courseDTO.category());
        courseEntity.setActive(courseDTO.active());
        courseEntity.setCreatedAt(courseEntity.getCreatedAt()); // Mantém o CreatedAt original.
        return this.courseRepository.save(courseEntity);
    }
}
