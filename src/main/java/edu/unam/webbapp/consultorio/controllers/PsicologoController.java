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

  /**
   * Funcion que permite visualizar los datos de una historia-clinica para ser mostrados
   * @param model permite establecer una clave y un valor para los atributos que pasan a la vista
   * @param dni permite ingresar el parametro dni
   * @return retorna la vista html
   */

  /**
   * Funcion que permite visualizar los datos de un psicologo para ser mostrados
   * @param model permite establecer una clave y un valor para los atributos que pasan a la vista
   * @return retorna la vista html
   */

  @GetMapping("/abm-psicologo")
  public String listar(Model model) {
    model.addAttribute("psicologos", service.findAll());
    model.addAttribute("titulo", "Crear Psicologo");
    model.addAttribute("especialidades", Especialidad.values());
    model.addAttribute("tipos", TipoDocumento.values());
    model.addAttribute("sexos", Sexo.values());
    model.addAttribute("psicologo", new Psicologo());
    return "psicologo/abmPsicologo";
  }

  /**
   * Funcion que permite guardar los datos de un psicologo para ser mostrados
   * @param psicologo parametro psicologo
   * @param result parametro para mapear los errores en el front-end
   * @param model permite establecer una clave y un valor para los atributos que pasan a la vista
   * @param status parametro que permite manejar la sesion dentro del controlador
   * @return retorna la vista html
   */

  @PostMapping("/form-psicologo")
  public String guardar(
      @Valid Psicologo psicologo, BindingResult result, Model model, SessionStatus status) {

    if (result.hasErrors()) {
      model.addAttribute("titulo", "Crear Psicologo");
      model.addAttribute("especialidades", Especialidad.values());
      model.addAttribute("tipos", TipoDocumento.values());
      model.addAttribute("sexos", Sexo.values());
      model.addAttribute("psicologos", service.findAll());
      return "psicologo/abmPsicologo";
    }

    service.save(psicologo);
    status.setComplete();
    return "redirect:/abm-psicologo";
  }


  /**
   * Funcion que permite editar los datos de un psicologo
   * @param id parametro que indica el id de un psicologo
   * @param model permite establecer una clave y un valor para los atributos que pasan a la vista
   * @return retorna la vista html
   */

  @GetMapping("/edit-psicologo/{id}")
  public String editar(@PathVariable("id") Integer id, Model model) {
    Psicologo psicologo;

    if (id > 0) {
      psicologo = service.getById(id);
      model.addAttribute("titulo", "Editar Psicologo");
      model.addAttribute("especialidades", Especialidad.values());
      model.addAttribute("tipos", TipoDocumento.values());
      model.addAttribute("sexos", Sexo.values());
      model.addAttribute("psicologos", service.findAll());
    } else {
      return "redirect:/abm-psicologo";
    }
    model.addAttribute("psicologo", psicologo);
    return "psicologo/abmPsicologo";
  }

  /**
   * Funcion que permite eliminar un psicologo a partir de su id
   * @param id parametro que indica el id de un psicologo
   * @return retorna la vista html
   */

  @GetMapping("/eliminar-psicologo/{id}")
  public String eliminar(@PathVariable("id") Integer id){
    if(id > 0){
      service.deleteById(id);
    }
    return "redirect:/abm-psicologo";
  }


}
