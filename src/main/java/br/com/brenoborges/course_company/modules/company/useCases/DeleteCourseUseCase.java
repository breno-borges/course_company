package br.com.brenoborges.course_company.modules.company.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brenoborges.course_company.exceptions.IdNotFoundException;
import br.com.brenoborges.course_company.modules.company.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id) {
        this.courseRepository.findById(id)
                // Verifica se o id existe, se não existe, lança mensagem de erro.
                .orElseThrow(() -> new IdNotFoundException());

        this.courseRepository.deleteById(id); // Remove a partir do Id passado ao chamar o método.
    }
}
