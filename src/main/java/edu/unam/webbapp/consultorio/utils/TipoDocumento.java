package edu.unam.webbapp.consultorio.utils;

public enum TipoDocumento {
    DNI("DNI"),
    LC("LC"),
    LE("LE"),
    PASAPORTE("PASAPORTE");

    private final String nombre;

    TipoDocumento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
