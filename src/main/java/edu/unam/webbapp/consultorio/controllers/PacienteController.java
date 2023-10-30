package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.services.PersonaService;
import edu.unam.webbapp.consultorio.utils.EstadoCivil;
import edu.unam.webbapp.consultorio.utils.Sexo;
import edu.unam.webbapp.consultorio.utils.TipoDocumento;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Clase PacienteController
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Controller
@RequiredArgsConstructor
@SessionAttributes("paciente")
public class PacienteController {

    private final PersonaService<Paciente> service;
    private final PersonaService<Psicologo> psicoService;

    @GetMapping("/abm-pacientes")
    public String CrearMostrar(Model model) {

        model.addAttribute("titulo", "Registrar nuevo paciente");
        Paciente paciente = new Paciente();
        Psicologo psicologo = new Psicologo();
        model.addAttribute("pacientes", service.findAll());
        model.addAttribute("tipos", TipoDocumento.values());
        model.addAttribute("sexos", Sexo.values());
        model.addAttribute("estados", EstadoCivil.values());
        model.addAttribute("paciente", paciente);
        model.addAttribute("psicologo", psicologo);
        model.addAttribute("psicologos", psicoService.findAll());
        return "pacientes/abmPaciente";
    }

    @PostMapping("/abm-pacientes")
    public String guardar(
            @RequestParam("psicologo") Integer psicoDni,
            @Valid Paciente paciente,
            BindingResult result,
            Model model,
            SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("pacientes", service.findAll());
            model.addAttribute("titulo", "Registrar nuevo paciente");
            model.addAttribute("tipos", TipoDocumento.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("estados", EstadoCivil.values());
            model.addAttribute("psicologos", psicoService.findAll());
            return "pacientes/abmPaciente";
        }

        Psicologo psicologo = psicoService.getById(psicoDni);
        paciente.setPsicologo(psicologo);
        paciente.setEliminado(Boolean.FALSE);
        psicologo.addPaciente(paciente);
        psicoService.save(psicologo);

        service.save(paciente);
        status.setComplete();
        return "redirect:/abm-pacientes";
    }

    @GetMapping("/abm-pacientes/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Paciente paciente;

        if (id > 0) {
            paciente = service.getById(id);
            model.addAttribute("pacientes", service.findAll());
            model.addAttribute("tipos", TipoDocumento.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("estados", EstadoCivil.values());
            model.addAttribute("psicologos", psicoService.findAll());
        } else {
            return "redirect:/abm-pacientes";
        }

        model.addAttribute("titulo", "Editando el Paciente");
        model.addAttribute("paciente", paciente);
        return "pacientes/abmPaciente";
    }

    @GetMapping("/eliminar-paciente/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        if (id > 0) {
            service.deleteById(id);
        }
        return "redirect:/abm-paciente";
    }
}