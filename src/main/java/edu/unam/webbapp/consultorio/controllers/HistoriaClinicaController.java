package edu.unam.webbapp.consultorio.controllers;

import edu.unam.webbapp.consultorio.model.HistoriaClinica;
import edu.unam.webbapp.consultorio.model.InformeSesion;
import edu.unam.webbapp.consultorio.services.HistoriaClinicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

/**
 * Clase HistoriaClinicaController
 *
 * @author Andre, Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Controller
@RequiredArgsConstructor
public class HistoriaClinicaController {

    private final HistoriaClinicaService service;


    @GetMapping("/historia-clinica")
    public String mostrar(Model model) throws Exception {
        List<HistoriaClinica> historiaClinica = service.findAllHistoriaClinica();
        Optional<List<InformeSesion>> sesions = historiaClinica.stream().map(HistoriaClinica::getInformeSesions).findFirst();
        sesions.ifPresent(informeSesions -> model.addAttribute("informes", informeSesions));

        return "historia/listado";
    }
}
