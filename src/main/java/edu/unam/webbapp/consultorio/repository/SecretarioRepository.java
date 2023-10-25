package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.Secretario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Clase Persona (clase padre)
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public interface SecretarioRepository extends JpaRepository<Secretario, Integer> {}
