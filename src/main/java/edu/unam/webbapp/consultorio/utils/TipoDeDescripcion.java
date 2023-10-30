package edu.unam.webbapp.consultorio.utils;

public enum TipoDeDescripcion {
    ANALISIS ("ANALISIS"),
    NOTAS ("NOTAS"),
    CONCLUSION ("CONCLUSION");

    private final String nombre;

    TipoDeDescripcion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
