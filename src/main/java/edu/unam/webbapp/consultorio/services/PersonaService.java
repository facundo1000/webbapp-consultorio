package edu.unam.webbapp.consultorio.services;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Interfaz que permite hacer uso de los metodos para un ABM
 * para un determinado tipo de persona
 *
 * @param <T> cualquier clase que sea necesaria
 * @author Andre, Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public interface PersonaService<T> {


    Page<T> getPageData(int page, int pageSize);


    /**
     * Funcion que retorna una lista de entidades
     *
     * @return lista de entidades
     */
    List<T> findAll();

    /**
     * Función que retorna una entidad a partir de su número de identificación
     *
     * @param id numero de identificacion
     * @return una entidad
     */
    T getById(Integer id);

    /**
     * Funcion que retorna una entidad a partir de otra entidad
     *
     * @param t un objeto
     * @return un objeto
     */
    T save(T t);

    /**
     * Función para actualizar una determinada entidad
     *
     * @param id número de indentificación
     * @param t  un objeto
     * @return un objeto
     */
    T update(Integer id, T t);

    /**
     * Función para eliminar lógicamente una entidad
     *
     * @param id numero de identificación
     */
    void deleteById(Integer id);
}
