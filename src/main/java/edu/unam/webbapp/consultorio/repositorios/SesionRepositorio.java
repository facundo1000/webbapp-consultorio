package edu.unam.webbapp.consultorio.repositorios;


import edu.unam.webbapp.consultorio.modelo.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepositorio extends JpaRepository<Sesion, Integer> {


}


