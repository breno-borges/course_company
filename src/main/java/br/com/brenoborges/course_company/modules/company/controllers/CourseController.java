package br.com.brenoborges.course_company.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brenoborges.course_company.modules.company.dto.CourseActiveDTO;
import br.com.brenoborges.course_company.modules.company.dto.CourseDTO;
import br.com.brenoborges.course_company.modules.company.entities.CourseEntity;
import br.com.brenoborges.course_company.modules.company.useCases.CreateCourseUseCase;
import br.com.brenoborges.course_company.modules.company.useCases.DeleteCourseUseCase;
import br.com.brenoborges.course_company.modules.company.useCases.ListCourseUseCase;
import br.com.brenoborges.course_company.modules.company.useCases.UpdateCourseUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListCourseUseCase listCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseDTO courseDTO) {
        CourseEntity newCourse = new CourseEntity(courseDTO); // Pego os dados da DTO e converto na entidade.
        try {
            var result = this.createCourseUseCase.execute(newCourse);
            return ResponseEntity.ok().body(result); // Exibe o resultado inserido no body
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get() {
        try {
            var listCourses = this.listCourseUseCase.execute();
            return ResponseEntity.ok().body(listCourses); // Exibe a lista no body
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteCourseUseCase.execute(id);
            return ResponseEntity.noContent().build(); // Exibe o status 204 No Content.
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @Valid @RequestBody CourseDTO courseDTO) {
        try {
            var result = this.updateCourseUseCase.put(id, courseDTO);
            return ResponseEntity.ok().body(result); // Exibe o resultado atualizado no body
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> updateActive(@PathVariable UUID id,
            @Valid @RequestBody CourseActiveDTO courseActiveDTO) {
        try {
            var result = this.updateCourseUseCase.patch(id, courseActiveDTO);
            return ResponseEntity.ok().body(result); // Exibe o resultado atualizado no body
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
