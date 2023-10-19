package edu.unam.webbapp.consultorio.services;

import edu.unam.webbapp.consultorio.model.Sesion;

import java.util.List;
import java.util.Optional;

/**
 *  Interfaz que permite hacer uso de los metodos para un ABM
 *  @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public interface SesionService {

  /**
   * Función que busca todas las sesiones almacenadas
   * @return listado de sesiones
   */
  List<Sesion> findAll();

  /**
   * Función para buscar sesiones por medio de su número de identificación
   * @param id número de identificación
   * @return un objeto sesion
   */
  Sesion findById(Integer id);

  /**
   * Función que se utiliza para persistir una entidad sesion
   * @param sesion un objeto sesion
   * @return un objeto sesion
   */
  Sesion save(Sesion sesion);

  /**
   * Función para actualizar una entidad usuario
   * @param id un número de identificación de sesion
   * @param sesion un objeto sesion
   * @return un objeto sesion modificado
   */
  Sesion update(Integer id, Sesion sesion);

  /**
   * Función que retorna una lista de sesiones a partir de un paciente
   * @param id número identificación de un paciente
   * @return lista de sesiones de un determinado paciente
   */
  List <Sesion> findSesionByPacienteId(Integer id);

  /**
   * Función que elimina logicamente a una determinada sesion
   * @param id número de identificación de una sesion
   */
  void deleteById(Integer id);
}
