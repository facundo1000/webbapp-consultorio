package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Secretario;
import edu.unam.webbapp.consultorio.repository.SecretarioRepository;
import edu.unam.webbapp.consultorio.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecretarioServiceImpl implements PersonaService<Secretario> {

    private final SecretarioRepository repo;

    @Override
    public List<Secretario> findAll() {
    return repo.findAll();
    }

    @Override
    public Secretario getById(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Secretario save(Secretario secretario) {
        return repo.save(secretario);
    }

    @Override
    public Secretario update(Integer id, Secretario secretario) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        Secretario secretario;
        if(id > 0){
            secretario = repo.findById(id).orElseThrow();
            secretario.setEliminado(true);
            repo.save(secretario);
        }
    }
}
