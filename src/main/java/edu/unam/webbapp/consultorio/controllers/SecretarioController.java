package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.Secretario;
import edu.unam.webbapp.consultorio.services.PersonaService;
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
@SessionAttributes("secretario")
public class SecretarioController {
  private final PersonaService<Secretario> service;

  @GetMapping("/listar-secretario")
  public String listar(Model model) {
    model.addAttribute("titulo", "Lista de Secretarios");
    model.addAttribute("secretarios", service.findAll());

    return "secretario/secretariosLista";
  }

  @GetMapping("/form-secretario")
  public String crear(Model model) {
    model.addAttribute("titulo", "Crear secretario");
    model.addAttribute("tipos", TipoDocumento.values());
    model.addAttribute("sexos", Sexo.values());
    model.addAttribute("secretario", new Secretario());
    return "secretario/formSecretario";
  }

  @PostMapping("/form-secretario")
  public String guardar(
      @Valid Secretario secretario, BindingResult result, Model model, SessionStatus status) {

    if(result.hasErrors()){
      model.addAttribute("titulo", "Crear secretario");
      model.addAttribute("tipos", TipoDocumento.values());
      model.addAttribute("sexos", Sexo.values());
      return "secretario/formSecretario";
    }

    service.save(secretario);
    status.setComplete();
    return "redirect:/listar-secretario";
  }


  @GetMapping("/form-secretario/{id}")
  public String editar(@PathVariable("id") Integer id, Model model){
    Secretario secretario;

    if(id > 0){
      secretario = service.getById(id);

      model.addAttribute("tipos", TipoDocumento.values());
      model.addAttribute("sexos", Sexo.values());
    }else {
      return "redirect:/listar-secretario";
    }
    model.addAttribute("titulo", "Editar secretario");
    model.addAttribute("secretario",secretario);
    return "secretario/secretariosLista";
  }

  @GetMapping("/eliminar-secretario/{id}")
  public String eliminar(@PathVariable("id") Integer id){
    if(id>0){
      service.deleteById(id);
    }
    return "redirect:/listar-secretario";
  }


}
