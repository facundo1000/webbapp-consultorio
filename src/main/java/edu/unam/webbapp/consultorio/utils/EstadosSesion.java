package edu.unam.webbapp.consultorio.utils;

/**
 * Enum EstadoSecion
 *
 * @author Andre, Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public enum EstadosSesion {
    REALIZADA("REALIZADA"),
    PENDIENTE("PENDIENTE"),
    CANCELADA("CANCELADA");

    private final String nombre;

    EstadosSesion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
