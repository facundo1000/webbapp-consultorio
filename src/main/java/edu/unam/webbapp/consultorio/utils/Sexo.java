package edu.unam.webbapp.consultorio.utils;

/**
 * Clase Sexo
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

    /**
     * Funcion que retorna la descripcion del sexo
     * @return descripcion
     */
    public String getNombre() {
        return nombre;
    }
}
