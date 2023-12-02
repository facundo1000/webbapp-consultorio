package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.HistoriaClinica;
import edu.unam.webbapp.consultorio.model.InformeSesion;
import edu.unam.webbapp.consultorio.repository.HistoriaClinicaRepository;
import edu.unam.webbapp.consultorio.repository.InformeSesionRepository;
import edu.unam.webbapp.consultorio.services.HistoriaClinicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase HistoriaClinicaServiceImpl
 *
 * @author Andre, Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository repo;
    private final InformeSesionRepository repoInforme;

    @Override
    public List<HistoriaClinica> findAllHistoriaClinica() throws Exception {

        List<HistoriaClinica> historiaClinicas = new ArrayList<>();

        List<InformeSesion> informes = repoInforme.findAll();

        if (!informes.isEmpty()) {

            List<Integer> integers = informes.stream()
                    .map(informeSesion -> informeSesion.getSesion().getPaciente().getDni()).distinct().toList();

            for (Integer dni : integers) {

                Optional<List<InformeSesion>> informesDni = repoInforme.getInformeSesionBySesion_Paciente_Dni(dni);


                informesDni.ifPresent(informeSesions -> {

                    HistoriaClinica historiaClinica = new HistoriaClinica();
                    historiaClinica.setInformeSesions(informeSesions);
                    historiaClinicas.add(historiaClinica);

                });
            }
            return historiaClinicas;
        }
        throw new Exception("no se encontraron informes almacenados");
    }
}
