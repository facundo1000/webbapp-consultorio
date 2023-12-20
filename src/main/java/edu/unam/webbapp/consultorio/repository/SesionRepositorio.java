package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.Sesion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase Persona (clase padre)
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Repository
public interface SesionRepositorio extends JpaRepository<Sesion, Integer> {

  /**
   * Funcion para retornar un listado de sesiones correspondientes
   * a un determinado paciente.
   * @param id numero de dni de un paciente
   * @return un listado de sesiones
   */
  List<Sesion> findSesionsByPacienteDni(Integer id);

  /**
   * Funcion que permite seleccionar una lista de sesiones con una fecha
   * anterior a una fecha dada
   * @param date localDate
   * @return una lista opcional de sesiones
   */
  Optional<List<Sesion>>findSesionByFechaBefore(LocalDate date);
}
