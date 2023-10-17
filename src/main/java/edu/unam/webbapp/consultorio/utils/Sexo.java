package edu.unam.webbapp.consultorio.utils;

/**
 * Clase Persona (clase padre)
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public enum Sexo {
    MASCULINO("MASCULINO"),
    FEMENINO("FEMENINO"),
    OTROS("OTROS");

    private final String nombre;

    Sexo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
