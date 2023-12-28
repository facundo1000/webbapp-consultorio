package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.Derivacion;
import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.services.DerivacionesService;
import edu.unam.webbapp.consultorio.services.impl.PacienteServiceImpl;
import edu.unam.webbapp.consultorio.services.impl.PsicologoServiceImpl;
import edu.unam.webbapp.consultorio.utils.TipoDocumento;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequiredArgsConstructor
@SessionAttributes("derivacion")
public class DerivacionController {

    private final DerivacionesService service;
    private final PsicologoServiceImpl psicoService;
    private final PacienteServiceImpl pacienteService;

    @GetMapping("/abm-derivaciones")
    public String crearDerivaciones(Model model) {
        model.addAttribute("psicos", psicoService.findAll());
        model.addAttribute("pacientes", pacienteService.findAll());
        model.addAttribute("derivaciones", service.findAll());
        model.addAttribute("tipoDoc", TipoDocumento.values());
        model.addAttribute("derivacion", new Derivacion());
        return "derivacion/abmDerivacion";
    }
//    @RequestParam(value = "psicologo", required = false) Integer psicoId,
    @PostMapping("/abm-derivaciones")
    public String guardarDerivacion(
            @RequestParam(value = "paciente", required = false) Integer pacienteId,
            @RequestParam(value = "descripcion") String descripcion,
            @Valid Derivacion derivacion,
            BindingResult result,
            Model model,
            SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("psicos", psicoService.findAll());
            model.addAttribute("pacientes", pacienteService.findAll());
            model.addAttribute("derivaciones", service.findAll());
            model.addAttribute("tipoDoc", TipoDocumento.values());
            return "derivacion/abmDerivacion";
        }


//        Psicologo psicologo = psicoService.getByDni(psicoId);
        Paciente paciente = pacienteService.getPacienteByDni(pacienteId);
        derivacion.setPsicologoEmisor(paciente.getPsicologo());
        derivacion.setPaciente(paciente);
        derivacion.setDescripcion(descripcion);

        service.save(derivacion);
        status.setComplete();
        return "redirect:/abm-derivaciones";
    }

}
