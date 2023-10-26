package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Secretario;
import edu.unam.webbapp.consultorio.repository.SecretarioRepository;
import edu.unam.webbapp.consultorio.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase SecretarioServiceImpl
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Service
@RequiredArgsConstructor
public class SecretarioServiceImpl implements PersonaService<Secretario> {

    private final SecretarioRepository repo;

    /**
     * Funcion que lista todos los secretarios disponibles
     * @return lista de secretarios
     */
    @Override
    public List<Secretario> findAll() {
    return repo.findAll();
    }

    /**
     * Funcion que busca un secretario a partir de su numero de identificacion
     * @param id numero de identificacion
     * @return un objeto secretario
     */
    @Override
    public Secretario getById(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    /**
     * Funcion que sirve para persistir un objeto secretario
     * @param secretario un objeto secretario
     * @return objeto secretario
     */
    @Override
    public Secretario save(Secretario secretario) {
        return repo.save(secretario);
    }

    /**
     * Funcion que sirve para actualizar un secretario a partir de su numero de identificacion
     * @param id número de indentificación
     * @param secretario un objeto secretario
     * @return objeto secreatario
     * @deprecated
     */
    @Override
    public Secretario update(Integer id, Secretario secretario) {
        return null;
    }

    /**
     * Funcion que elimina logicamente un secretario.<br>
     * Verifica si el secretario se encuentra disponible.
     * Una vez que lo encuentra configura el setEliminado en TRUE y
     * luego persiste el objeto modificado.
     * @param id numero de identificación
     */

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
