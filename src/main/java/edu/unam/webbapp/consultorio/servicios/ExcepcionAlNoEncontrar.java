package edu.unam.webbapp.consultorio.servicios;

public class ExcepcionAlNoEncontrar extends RuntimeException{
    ExcepcionAlNoEncontrar(int id) {super("Excepcion: Objeto no encontrado: " + id);}
}
