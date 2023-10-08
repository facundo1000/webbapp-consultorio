package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.services.PersonaService;
import edu.unam.webbapp.consultorio.utils.EstadoCivil;
import edu.unam.webbapp.consultorio.utils.Sexo;
import edu.unam.webbapp.consultorio.utils.TipoDocumento;
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

@Controller
@RequiredArgsConstructor
@SessionAttributes("paciente")
public class PacienteController {

  private final PersonaService<Paciente> service;

  @GetMapping("/lista-pacientes")
  public String mostrar(Model model) {

    model.addAttribute("titulo", "Listado de Pacientes");
    model.addAttribute("pacientes", service.findAll());
    return "pacientes/pacientesLista";
  }

  @GetMapping("/form-paciente")
  public String crear(Model model) {
    Paciente paciente = new Paciente();
    model.addAttribute("titulo", "Registro de Paciente");
    model.addAttribute("tipos", TipoDocumento.values());
    model.addAttribute("sexos", Sexo.values());
    model.addAttribute("estados", EstadoCivil.values());
    model.addAttribute("paciente", paciente);
    return "pacientes/formPaciente";
  }

  @PostMapping("/form-paciente")
  public String guardar(
      @Valid Paciente paciente, BindingResult result, Model model, SessionStatus status) {

    if (result.hasErrors()) {
      model.addAttribute("titulo", "Registro de Paciente");
      model.addAttribute("tipos", TipoDocumento.values());
      model.addAttribute("sexos", Sexo.values());
      model.addAttribute("estados", EstadoCivil.values());
      return "pacientes/formPaciente";
    }
    service.save(paciente);
    status.setComplete();
    return "redirect:/lista-pacientes";
  }

  @GetMapping("/form-paciente/{id}")
  public String editar(@PathVariable("id") Integer id, Model model) {
    Paciente paciente;

    if (id > 0) {
      paciente = service.getById(id);
      model.addAttribute("tipos", TipoDocumento.values());
      model.addAttribute("sexos", Sexo.values());
      model.addAttribute("estados", EstadoCivil.values());
    } else {
      return "redirect:/lista-pacientes";
    }

    model.addAttribute("titulo", "Editar Paciente");
    model.addAttribute("paciente", paciente);
    return "pacientes/formPaciente";
  }

  @GetMapping("/eliminar-paciente/{id}")
  public String eliminar(@PathVariable("id") Integer id) {
    if (id > 0) {
      service.deleteById(id);
    }
    return "redirect:paciente/lista-pacientes";
  }
}
