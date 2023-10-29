package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.services.PersonaService;
import edu.unam.webbapp.consultorio.utils.Especialidad;
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
/**
 * Clase PsicologoController
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Controller
@RequiredArgsConstructor
@SessionAttributes("psicologo")
public class PsicologoController {

  private final PersonaService<Psicologo> service;

  @GetMapping("/lista-psicologos")
  public String listar(Model model) {

    model.addAttribute("titulo", "Listado de Psicologos");
    model.addAttribute("psicologos", service.findAll());

    return "psicologo/psicologosLista";
  }

  @GetMapping("/form-psicologo")
  public String crear(Model model) {
    model.addAttribute("titulo", "Crear Psicologo");
    model.addAttribute("especialidades", Especialidad.values());
    model.addAttribute("tipos", TipoDocumento.values());
    model.addAttribute("sexos", Sexo.values());
    model.addAttribute("psicologo", new Psicologo());
    return "psicologo/formPsicologo";
  }

  @PostMapping("/form-psicologo")
  public String guardar(
      @Valid Psicologo psicologo, BindingResult result, Model model, SessionStatus status) {

    if (result.hasErrors()) {
      model.addAttribute("titulo", "Crear Psicologo");
      model.addAttribute("especialidades", Especialidad.values());
      model.addAttribute("tipos", TipoDocumento.values());
      model.addAttribute("sexos", Sexo.values());
      return "psicologo/formPsicologo";
    }

    service.save(psicologo);
    status.setComplete();
    return "redirect:/lista-psicologos";
  }


  @GetMapping("/form-psicologo/{id}")
  public String editar(@PathVariable("id") Integer id, Model model) {
    Psicologo psicologo;

    if (id > 0) {
      psicologo = service.getById(id);
      model.addAttribute("titulo", "Editar Psicologo");
      model.addAttribute("especialidades", Especialidad.values());
      model.addAttribute("tipos", TipoDocumento.values());
      model.addAttribute("sexos", Sexo.values());
      model.addAttribute("psicologo", psicologo);
      return "psicologo/formPsicologo";
    } else {
      return "redirect:/lista-psicologos";
    }
  }

  @GetMapping("/eliminar-psicologo/{id}")
  public String eliminar(@PathVariable("id") Integer id){
    if(id > 0){
      service.deleteById(id);
    }
    return "redirect:/lista-psicologos";
  }


}
