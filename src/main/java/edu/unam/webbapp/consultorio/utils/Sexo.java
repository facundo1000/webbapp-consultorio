package edu.unam.webbapp.consultorio.utils;

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
