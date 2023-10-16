package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.Sesion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepositorio extends JpaRepository<Sesion, Integer> {
  List<Sesion> findSesionsByPacienteDni(Integer id);
}
