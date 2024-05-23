package com.example.Crud.repositorio;

import com.example.Crud.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, Long> {
    //Alumno findByCorreo(String email);
    List<Alumno> NombreContaining(String nombre);

}
