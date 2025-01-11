package com.espe.cursos.services;

import com.espe.cursos.model.entities.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    List<Estudiante> findAll();
    List<Estudiante> findAllByIds(List<Long> ids);
    Optional<Estudiante> findById(Long id);
    Estudiante save(Estudiante estudiante);
    void deleteById(Long id);
}
