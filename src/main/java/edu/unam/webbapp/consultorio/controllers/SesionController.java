package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.services.PersonaService;
import edu.unam.webbapp.consultorio.services.impl.SesionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("sesion")
public class SesionController {

  private final SesionService service;
  private final PersonaService<Psicologo> psicoService;
  private final PersonaService<Paciente> pasService;

  @GetMapping("/lista-sesiones")
  public String listar(Model model, Integer id) {
    model.addAttribute("titulo", "Listado de Sesiones");
    model.addAttribute("sesiones", service.findAll());
//    model.addAttribute("psicologo",psicoService.getById(id));
    return "listaSesiones";
  }

  @GetMapping("/form-sesiones")
  public String crear(Model model) {
    model.addAttribute("titulo", "Crear de Sesion");
    model.addAttribute("sesion",new Sesion());
    model.addAttribute("psicologos",psicoService.findAll());
    model.addAttribute("pacientes",pasService.findAll());
    return "formSesiones";
  }


  @PostMapping("/form-sesiones")
  public String guardar(
      @Valid Sesion sesion, BindingResult result, Model model, SessionStatus status) {

    if (result.hasErrors()) {
      model.addAttribute("titulo", "Crear de Sesion");
    }



    service.save(sesion);
    status.setComplete();
    return "redirect:/lista-sesiones";
  }

  @GetMapping("/listar-sesiones/{id}")
  public String sesionPorPaciente(@PathVariable("id") Integer id, Model model){
    List<Sesion> sesions = service.findSesionByPacienteId(id);

    model.addAttribute("titulo", "Listado de sesiones");
    model.addAttribute("sesiones", sesions);

    return "pacientes/sesionesPorPaciente";
  }

}
