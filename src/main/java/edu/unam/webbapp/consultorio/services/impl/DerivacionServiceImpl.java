package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Derivacion;
import edu.unam.webbapp.consultorio.repository.DerivacionesRepository;
import edu.unam.webbapp.consultorio.services.DerivacionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DerivacionServiceImpl implements DerivacionesService {

    private final DerivacionesRepository repo;

    @Override
    public List<Derivacion> findAll() {
        return repo.findAll();
    }

    @Override
    public Derivacion findById(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Derivacion save(Derivacion derivacion) {
        return repo.save(derivacion);
    }


    @Override
    public void deleteById(Integer id) {
        Derivacion derivacion = repo.findById(id).orElseThrow();
        derivacion.setEliminado(true);
        repo.save(derivacion);
    }
}
