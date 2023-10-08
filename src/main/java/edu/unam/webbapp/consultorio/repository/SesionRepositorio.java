package edu.unam.webbapp.consultorio.repository;


import edu.unam.webbapp.consultorio.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SesionRepositorio extends JpaRepository<Sesion, Integer> {
    List<Sesion>findSesionsByPacienteDni(Integer id);

}


