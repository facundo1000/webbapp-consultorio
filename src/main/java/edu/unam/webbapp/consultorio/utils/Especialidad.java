package edu.unam.webbapp.consultorio.utils;

/**
 * Clase Especialidad correspondiente a un psicologo
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public enum Especialidad {
  PSICOANALISIS("PSICOANALISIS"),
  PSICOTERAPIA("PSICOTERAPIA");

  private final String nombre;

  Especialidad(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Funcion que retorna el nombre de una especialidad
   * @return un nombre de especialidad
   */
  public String getNombre() {
    return nombre;
  }
}
