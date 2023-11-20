package edu.unam.webbapp.consultorio.repository;

import edu.unam.webbapp.consultorio.model.InformeSesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
/**
 * Interfaz InformeSesionRepository
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public interface InformeSesionRepository extends JpaRepository<InformeSesion, Integer>{
    /**
     * Funcion que permite obtener un Informe de sesion a partir del ID de la sesion.
     * @param id numero de identificacion de la sesion
     * @return un objeto Optional InformeSesion
     */
    Optional<InformeSesion> getInformeSesionBySesion_NroSesion(Integer id);

    /**
     * Funcion que obtiene de la bases de datos una lista de informes de sesion
     * a partir del numero de identificacion de un paciente en una sesion.
     * @param dni numero de identificacion de un paciente
     * @return una objeto Optional List InformeSesion
     */
    Optional<List<InformeSesion>>getInformeSesionBySesion_Paciente_Dni(Integer dni);
    }
