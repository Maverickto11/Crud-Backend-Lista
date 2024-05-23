package com.example.Crud.alumnoServicio;

import com.example.Crud.modelo.Alumno;
import com.example.Crud.repositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServicio {

    @Autowired
    private AlumnoRepositorio estudianteRepository;

    public Alumno actualizarEstudiante(Long id, Alumno estudianteActualizado) {
        Alumno estudianteExistente = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        estudianteExistente.setNombre(estudianteActualizado.getNombre());
        estudianteExistente.setApellido(estudianteActualizado.getApellido());
        estudianteExistente.setEmail(estudianteActualizado.getEmail());

        return estudianteRepository.save(estudianteExistente);
    }
}