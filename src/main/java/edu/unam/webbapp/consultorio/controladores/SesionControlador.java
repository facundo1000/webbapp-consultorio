package edu.unam.webbapp.consultorio.controladores;


import edu.unam.webbapp.consultorio.servicios.SesionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SesionControlador {



    @Autowired
    SesionServicio sesionServicio;

    public SesionControlador(SesionServicio sesionServicio){ this.sesionServicio = sesionServicio;}

    @GetMapping("/sesiones")
    public String index(Model modelo) {
        var sesion = sesionServicio.MostrarSesiones();
        return null;
    }

}
