package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.services.impl.PacienteServiceImpl;
import edu.unam.webbapp.consultorio.services.SesionService;
import jakarta.validation.Valid;

import java.time.LocalDate;
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
@SessionAttributes(value = {"sesion" ,"pacientes"})
public class SesionController {

  private final SesionService service;
//  private final PersonaService<Psicologo> psicoService;
  private final PacienteServiceImpl pasService;

  /**
   * Este metodo permite visualizar la pantalla de sesiones
   * @param model
   * @return la vista en html de abmSesion.html
   */
  @GetMapping(path = {"/","/lista-sesiones"})
  public String listar(Model model) {
    Sesion sesion = new Sesion();
    model.addAttribute("sesion", sesion);
    model.addAttribute("pacientes", pasService.getAllEliminadoEquals(false));
    model.addAttribute("sesiones", service.findAll());
    return "sesiones/abmSesion";
  }

  /**
   * Funcion que permite visualizar los datos de una sesion para ser editados
   * @param model
   * @param id id de una sesion en especifica
   * @return la vista en html de abmSesion.html
   */

  @GetMapping("/lista-sesiones/{id}")
  public String editar(Model model, @PathVariable Integer id) {

    Sesion sesion;

    if(id > 0){
      sesion = service.findById(id);
      model.addAttribute("sesiones", service.findAll());
    }else {
      return "redirect:/lista-sesiones";
    }

   model.addAttribute("sesion",sesion);
    return "sesiones/abmSesion";
  }

  /**
   * Funcion que se encarga de manejar la confirmacion de una sesion
   * @param paciente objeto paciente
   * @param sesion objeto sesion
   * @param result permite ver si hubo errores en el proceso de relleno del formulario
   * @param model
   * @param status permite manejar la sesion
   * @return redireciona al controlador que muestra
   */

  @PostMapping("/form-sesiones")
  public String guardar(
      @RequestParam("paciente") Paciente paciente,
      @RequestParam(name = "fecha")LocalDate fecha,
      @Valid Sesion sesion,
      BindingResult result,
      Model model,
      SessionStatus status) {

    if (result.hasErrors()) {
      model.addAttribute("pacientes", pasService.findAll());
    }

    paciente.getPsicologo().addSesion(sesion);
    paciente.addSesion(sesion);

    sesion.setPsicologo(paciente.getPsicologo());

    service.save(service.sesionStatus(fecha,sesion));
    status.setComplete();
    return "redirect:/";
  }

  @GetMapping("/listar-sesiones/{id}")
  public String sesionPorPaciente(@PathVariable("id") Integer id, Model model) {
    List<Sesion> sesions = service.findSesionByPacienteId(id);
    Paciente paciente = pasService.getById(id);

    model.addAttribute("titulo", "Listado de sesiones");
    model.addAttribute("sesiones", sesions);
    model.addAttribute("paciente",paciente);

    return "pacientes/sesionesPorPaciente";
  }

  @GetMapping("/eliminar-sesion/{id}")
  public String eliminarSesion(@PathVariable Integer id){
    if(id > 0){
      service.deleteById(id);
    }
    return "redirect:/";
  }
}
