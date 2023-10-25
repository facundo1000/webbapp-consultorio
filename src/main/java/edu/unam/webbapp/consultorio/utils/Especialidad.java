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

  public String getNombre() {
    return nombre;
  }
}
