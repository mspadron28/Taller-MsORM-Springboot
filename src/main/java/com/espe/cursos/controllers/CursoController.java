package com.espe.cursos.controllers;

import com.espe.cursos.model.entities.Curso;
import com.espe.cursos.services.CursoService;
import com.espe.cursos.model.entities.Estudiante;
import com.espe.cursos.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
@RestController
@RequestMapping("api/cursos")
public class CursoController  {
    //Instanciar el servicio cunando se necesite y liberar memoria
    @Autowired
    private CursoService service;

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    //Devolver un objeto generico en caso de que la app se caiga
    public ResponseEntity<?> crear(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(curso));
    }

    @GetMapping
    public List<Curso> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable Long id) {
        Optional<Curso> cursoOptional = service.findById(id);
        if (cursoOptional.isPresent()) {
            return ResponseEntity.ok(cursoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Curso curso) {
        Optional<Curso> cursoOptional = service.findById(id);
        if (cursoOptional.isPresent()) {
            Curso cursoDB = cursoOptional.get();
            cursoDB.setNombre(curso.getNombre());
            cursoDB.setDescripcion(curso.getDescripcion());
            cursoDB.setCreditos(curso.getCreditos());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));
        }
        return ResponseEntity.notFound().build();
    }
    //Asignar estudiantes a un curso
    @PostMapping("/{cursoId}/estudiantes")
    public ResponseEntity<?> asignarEstudiantes(@PathVariable Long cursoId, @RequestBody List<Long> estudiantesIds) {
        Optional<Curso> cursoOptional = service.findById(cursoId);
        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            List<Estudiante> estudiantes = estudianteService.findAllByIds(estudiantesIds);
            curso.getEstudiantes().addAll(estudiantes);
            service.save(curso);
            return ResponseEntity.ok(curso);
        }
        return ResponseEntity.notFound().build();
    }

}
