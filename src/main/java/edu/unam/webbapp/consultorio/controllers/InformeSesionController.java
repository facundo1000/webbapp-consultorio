package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.InformeSesion;
import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.services.SesionService;
import edu.unam.webbapp.consultorio.services.impl.InformeSesionServiceImpl;
import edu.unam.webbapp.consultorio.utils.EstadosSesion;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Clase InformeSesionController
 */

@Controller
@RequiredArgsConstructor
@SessionAttributes("informe")
public class    InformeSesionController {

    private final InformeSesionServiceImpl service;
    @GetMapping(path = {"/informe/{id}", "/informe"})
    public String crearInforme(@PathVariable Integer id, Model model) {
        InformeSesion informe = service.createInformeSesion(id);
        model.addAttribute("informe", informe);
        model.addAttribute("boton",service.existeInformeSesion(id));
        return "informeSesion/informeSesion";
    }

    @GetMapping("informe-mostrar/{id}")
    public String buscarInforme(@PathVariable Integer id, Model model){
        model.addAttribute("informe",service.findById(id));
        return "informeSesion/informeSesion";
    }

    @PostMapping("/informe/{id}")
    public String enviarInforme(@RequestParam("analisis") String analisis,
                                @RequestParam("tareas") String tareas,
                                @RequestParam("notas") String notas,
                                @RequestParam("conclusion") String conclusion,
                                @PathVariable Integer id,
                                @Valid InformeSesion informe,
                                BindingResult result, Model model) {


        if (result.hasErrors()) {
            model.addAttribute("informe", informe);
            return "informeSesion/informeSesion";
        }


        service.formInformation(analisis, tareas, notas, conclusion, id, informe);
        service.save(informe);
        return "redirect:/";
    }


}
