package edu.unam.webbapp.consultorio.utils;

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
