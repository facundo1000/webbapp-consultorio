package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.InformeSesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InformeSesionRepository extends JpaRepository<InformeSesion, Integer>{
    Optional<InformeSesion> getInformeSesionBySesion_NroSesion(Integer id);

    }
