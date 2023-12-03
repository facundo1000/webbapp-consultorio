package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.Derivacion;
import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.services.DerivacionesService;
import edu.unam.webbapp.consultorio.services.PersonaService;
import edu.unam.webbapp.consultorio.utils.EstadoCivil;
import edu.unam.webbapp.consultorio.utils.Sexo;
import edu.unam.webbapp.consultorio.utils.TipoDocumento;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequiredArgsConstructor
@SessionAttributes("derivacion")
public class DerivacionController {

    private final DerivacionesService service;
    private final PersonaService<Psicologo> psicoService;
    private final PersonaService<Paciente> pacienteService;

    @GetMapping("/abm-derivaciones")
    public String crearDerivaciones(Model model) {
        model.addAttribute("psicos",psicoService.findAll());
        model.addAttribute("pacientes",pacienteService.findAll());
        model.addAttribute("derivaciones", service.findAll());
        model.addAttribute("tipoDoc", TipoDocumento.values());
        model.addAttribute("derivacion", new Derivacion());
        return "derivacion/abmDerivacion";
    }

    @PostMapping("/abm-derivaciones")
    public String guardarDerivacion(@Valid Derivacion derivacion, BindingResult result, Model model, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("psicos",psicoService.findAll());
            model.addAttribute("pacientes",pacienteService.findAll());
            model.addAttribute("derivaciones", service.findAll());
            model.addAttribute("tipoDoc", TipoDocumento.values());
            model.addAttribute("derivacion", new Derivacion());
            model.addAttribute("derivacion", derivacion);
        } else {
            return "redirect:/abm-derivaciones";
        }
        service.save(derivacion);
        status.setComplete();
        return "derivacion/abmDerivacion";
    }

    @GetMapping("/abm-derivaciones/{id}")
    public String editar(@RequestParam(name = "page", defaultValue = "0") int page, @PathVariable("id") Integer id, Model model) {
        Derivacion derivacion;
//        int pageSize = 2;
//        Page<Derivacion> pageData = service.getPageData(page,pageSize);

        if (id > 0) {
            derivacion = service.findById(id);
            model.addAttribute("psicos",psicoService.findAll());
            model.addAttribute("pacientes",pacienteService.findAll());
            model.addAttribute("derivaciones", service.findAll());
            model.addAttribute("tipoDoc", TipoDocumento.values());
            model.addAttribute("derivacion", derivacion);
//           model.addAttribute("pageData",pageData);
        } else {
            return "redirect:/abm-derivaciones";
        }
        model.addAttribute("derivacion", derivacion);
        return "derivacion/abmDerivacion";
    }




    @DeleteMapping("/eliminar-derivaciones/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        if (id > 0) {
            service.deleteById(id);
        }
        return "redirect:/abm-derivaciones";
    }
}
