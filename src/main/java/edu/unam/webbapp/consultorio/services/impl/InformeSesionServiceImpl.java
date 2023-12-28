package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.InformeSesion;
import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.repository.InformeSesionRepository;
import edu.unam.webbapp.consultorio.repository.SesionRepositorio;
import edu.unam.webbapp.consultorio.services.InformeSesionService;
import edu.unam.webbapp.consultorio.services.SesionService;
import edu.unam.webbapp.consultorio.utils.EstadosSesion;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Clase InformeSesionServiceImpl
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Service
@RequiredArgsConstructor
public class InformeSesionServiceImpl implements InformeSesionService {

    private final InformeSesionRepository repo;
    private final SesionRepositorio repoSesion;
    private final SesionService sesionService;
    @Override
    public List<InformeSesion> findAll() {
        return repo.findAll();
    }

    @Override
    public InformeSesion findById(Integer id) {
        return repo.findById(id).orElseThrow() ;
    }

    @Override
    public InformeSesion save(InformeSesion informe) {
        return repo.save(informe);
    }

    @Override
    public InformeSesion update(Integer id, InformeSesion informe) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        if (id > 0){
            InformeSesion informe = repo.findById(id).orElseThrow();
            informe.setEliminado(true);
            repo.save(informe);
        }
    }

    @Override
    public InformeSesion createInformeSesion(Integer id) {

        InformeSesion informe = new InformeSesion();
        Optional<Sesion> sesion = repoSesion.findById(id);

        if(sesion.isPresent()){
            if(sesion.get().getInformeSesion() != null){
                return repo.getInformeSesionBySesion_NroSesion(id).orElseThrow();
            }
            informe.setSesion(sesion.get());
        }

        return informe;
    }

    @Override
    public Boolean existeInformeSesion(Integer id) {
        Optional<Sesion> sesion = repoSesion.findById(id);

        if(sesion.isPresent()){
            if(sesion.get().getInformeSesion() != null){
                InformeSesion informeSesion = repo.getInformeSesionBySesion_NroSesion(id).orElseThrow();
                return informeSesion.equals(sesion.get().getInformeSesion());
            }
        }
        return null;
    }

    public void formInformation(String analisis, String tareas, String notas, String conclusion, Integer id, InformeSesion informe){
        Sesion sesion = sesionService.findById(id);
        informe.setAnalisis(analisis);
        informe.setTareas(tareas);
        informe.setNotas(notas);
        informe.setConclusion(conclusion);
        informe.setSesion(sesion);
        informe.setFechaSesion(sesion.getFecha());
        informe.setHoraSesion(sesion.getHora());
        sesion.setInformeSesion(informe);
        sesion.setEstadosSesion(EstadosSesion.REALIZADA);
    }
}
