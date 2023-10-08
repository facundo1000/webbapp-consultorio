package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {}
