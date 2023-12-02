package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.HistoriaClinica;
import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.services.HistoriaClinicaService;
import edu.unam.webbapp.consultorio.services.PersonaService;
import edu.unam.webbapp.consultorio.services.SesionService;
import edu.unam.webbapp.consultorio.services.impl.PacienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Clase HistoriaClinicaController
 *
 * @author Andre, Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Controller
@RequiredArgsConstructor
public class HistoriaClinicaController {

    private final HistoriaClinicaService service;

    private final PacienteServiceImpl servicPaciente;

    private final SesionService sesionService;

    @GetMapping("/historia-clinica")
    public String mostrar(Model model) throws Exception {
        List<HistoriaClinica> historiaClinica = service.findAllHistoriaClinica();
        model.addAttribute("informes", historiaClinica);
        return "historia/listado";
    }

    @GetMapping("/informe-detalle/{dni}")
    public String mostrarListadoInformesDeSesionXPaciente(Model model, @PathVariable Integer dni) {
        Paciente paciente;
        List<Sesion> sesions;

        if(dni > 0){
            paciente = servicPaciente.getPacienteByDni(dni);
            sesions = sesionService.findSesionByPacienteId(dni);
        }else{
            return "redirect:/historia-clinica";
        }

        model.addAttribute("paciente",paciente);
        model.addAttribute("sesions",sesions);
        return "historia/detalle";
    }
}
