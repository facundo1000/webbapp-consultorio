package edu.unam.webbapp.consultorio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.unam.webbapp.consultorio.modelo.Sesion;
import edu.unam.webbapp.consultorio.repositorios.SesionRepositorio;



@Service
public class SesionServicio {

    @Autowired
    SesionRepositorio sesionRepositorio;

    public SesionServicio (SesionRepositorio sesionRepositorio) {this.sesionRepositorio = sesionRepositorio;}

    public void agregarSesion(Sesion sesion) {sesionRepositorio.save(sesion);}

    public Sesion buscarSesionPorId(int id) {
        return sesionRepositorio.findById(id).orElseThrow(() -> new ExcepcionAlNoEncontrar(id));

    }
    public List<Sesion> MostrarSesiones(){return sesionRepositorio.findAll();}




}
