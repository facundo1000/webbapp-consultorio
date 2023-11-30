package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Interface Persona (clase padre)
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {

    /**
     * Listado para tomar todos los pacientes que no hayan sido eliminados
     * @param eliminado
     * @return un listado de pacientes
     */
    List<Paciente> findAllByEliminadoEquals(Boolean eliminado);

    /**
     * Funcion que sirve para encontrar un paciente a partir de su dni.
     * @param dni numero entero dni
     * @return un paciente
     */

    Optional<Paciente> findByDni(Integer dni);
}
