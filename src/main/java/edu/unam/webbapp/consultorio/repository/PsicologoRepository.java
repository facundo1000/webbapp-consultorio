package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Clase Persona (clase padre)
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public interface PsicologoRepository extends JpaRepository<Psicologo, Integer> {

    /**
     * Funcion que hace una query a la base de datos para retornar un psicologo a partir de su dni
     * @param dni numero de dni
     * @return Optional de Psicologo
     */
    Optional<Psicologo> findByDni(Integer dni);
}
