package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.InformeSesion;
import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.services.SesionService;
import edu.unam.webbapp.consultorio.services.impl.InformeSesionServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@SessionAttributes
public class InformeSesionController {

    private final InformeSesionServiceImpl service;
    private final SesionService sesionService;
    @GetMapping(path = {"/informe/{id}", "/informe"})
    public String crearInforme(@PathVariable Integer id, Model model) {
        InformeSesion informe = service.createInformeSesion(id);
        model.addAttribute("informe", informe);
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



        Sesion sesion = sesionService.findById(id);
        informe.setAnalisis(analisis);
        informe.setTareas(tareas);
        informe.setNotas(notas);
        informe.setConclusion(conclusion);
        informe.setSesion(sesion);
        service.save(informe);
        return "redirect:/";
    }
}
