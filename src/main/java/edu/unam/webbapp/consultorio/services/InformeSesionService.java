package edu.unam.webbapp.consultorio.services;

import edu.unam.webbapp.consultorio.model.InformeSesion;
import edu.unam.webbapp.consultorio.model.Sesion;

import java.util.List;

public interface InformeSesionService {

    /**
     * Función que busca todas las sesiones almacenadas
     * @return listado de sesiones
     */
    List<InformeSesion> findAll();

    /**
     * Función para buscar sesiones por medio de su número de identificación
     * @param id número de identificación
     * @return un objeto sesion
     */
    InformeSesion findById(Integer id);

    /**
     * Función que se utiliza para persistir una entidad sesion
     * @param informe un objeto sesion
     * @return un objeto sesion
     */
    InformeSesion save(InformeSesion informe);

    /**
     * Función para actualizar una entidad usuario
     * @param id un número de identificación de sesion
     * @param informe un objeto sesion
     * @return un objeto sesion modificado
     */
    InformeSesion update(Integer id, InformeSesion informe);


    /**
     * Función que elimina logicamente a una determinada sesion
     * @param id número de identificación de una sesion
     */
    void deleteById(Integer id);

    InformeSesion createInformeSesion(Integer id);
}
