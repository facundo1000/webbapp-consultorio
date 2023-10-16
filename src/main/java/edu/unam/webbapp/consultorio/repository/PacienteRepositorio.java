package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
    List<Paciente> findAllByEliminadoEquals(Boolean eliminado);
}
