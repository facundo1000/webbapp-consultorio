package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.InformeSesion;
import edu.unam.webbapp.consultorio.repository.InformeSesionRepository;
import edu.unam.webbapp.consultorio.services.InformeSesionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InformeSesionServiceImpl implements InformeSesionService {

    private final InformeSesionRepository repo;

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
}
