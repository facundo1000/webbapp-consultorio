package edu.unam.webbapp.consultorio.utils;

/**
 * Clase Tipo de Documento
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
public enum TipoDocumento {
    DNI("DNI"),
    LC("LC"),
    LE("LE"),
    PASAPORTE("PASAPORTE");

    private final String nombre;

    TipoDocumento(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Funcion que retorna el nombre de cada documento
     * @return nombre de un documento
     */
    public String getNombre() {
        return nombre;
    }
}
