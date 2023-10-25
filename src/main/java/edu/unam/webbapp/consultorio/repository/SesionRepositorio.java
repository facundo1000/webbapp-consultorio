package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.Sesion;
import java.util.List;
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
   * @param id
   * @return un listado de sesiones
   */
  List<Sesion> findSesionsByPacienteDni(Integer id);
}
