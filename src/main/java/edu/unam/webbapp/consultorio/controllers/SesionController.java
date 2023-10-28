package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.services.PersonaService;
import edu.unam.webbapp.consultorio.services.impl.PacienteServiceImpl;
import edu.unam.webbapp.consultorio.services.SesionService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
/**
 * Clase SesionController
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Controller
@RequiredArgsConstructor
@SessionAttributes("sesion")
public class SesionController {

  private final SesionService service;
  private final PersonaService<Psicologo> psicoService;
  private final PacienteServiceImpl pasService;

  @GetMapping("/")
  public String listar(Model model, Integer id) {
    model.addAttribute("titulo", "Listado de Sesiones");
    model.addAttribute("sesiones", service.findAll());
    return "listaSesiones";
  }

  @GetMapping("/form-sesiones")
  public String crear(Model model) {
    Sesion sesion = new Sesion();
    model.addAttribute("titulo", "Crear de Sesion");
    model.addAttribute("sesion", sesion);
    model.addAttribute("sesionNum", sesion.getNroSesion());
    model.addAttribute("psicologos", psicoService.findAll());
    model.addAttribute("pacientes", pasService.getAllEliminadoEquals(false));
    return "formSesiones";
  }

  @PostMapping("/form-sesiones")
  public String guardar(
      @RequestParam("paciente") Paciente paciente,
      @Valid Sesion sesion,
      BindingResult result,
      Model model,
      SessionStatus status) {

    if (result.hasErrors()) {
      model.addAttribute("titulo", "Crear de Sesion");
      model.addAttribute("psicologos", psicoService.findAll());
      model.addAttribute("pacientes", pasService.findAll());
    }

    paciente.getPsicologo().addSesion(sesion);
    paciente.addSesion(sesion);

    sesion.setPsicologo(paciente.getPsicologo());

    service.save(sesion);
    status.setComplete();
    return "redirect:/lista-sesiones";
  }

  @GetMapping("/listar-sesiones/{id}")
  public String sesionPorPaciente(@PathVariable("id") Integer id, Model model) {
    List<Sesion> sesions = service.findSesionByPacienteId(id);

    model.addAttribute("titulo", "Listado de sesiones");
    model.addAttribute("sesiones", sesions);

    return "pacientes/sesionesPorPaciente";
  }
}
