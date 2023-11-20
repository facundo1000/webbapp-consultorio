package edu.unam.webbapp.consultorio.services;

import edu.unam.webbapp.consultorio.model.HistoriaClinica;

import java.util.List;
/**
 * Interfaz HistoriaClinicaService
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public interface HistoriaClinicaService {

    /**
     * Funcion que devuelve una lista de historias clinicas
     * @return un objeto List de la clase HistoriasClinicas
     */
    List<HistoriaClinica> findAllHistoriaClinica() throws Exception;

}
