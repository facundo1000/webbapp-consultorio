package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.repository.PsicologoRepository;
import edu.unam.webbapp.consultorio.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase PsicologoServiceImpl
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Service
@RequiredArgsConstructor
public class PsicologoServiceImpl implements PersonaService<Psicologo> {

  private final PsicologoRepository repo;

  /**
   * Funcion que retorna una lista de psicologos
   * @return lista de psicologos
   */
  @Override
  public List<Psicologo> findAll() {
    return repo.findAll();
  }

  /**
   * Funcion que retorna un psicologo a partir de su numero de identificacion
   * @param id numero de identificacion
   * @return un psicologo
   */
  @Override
  public Psicologo getById(Integer id) {
    return repo.findById(id).orElseThrow();
  }

  /**
   * Funcion que retorna un psicologo y lo persiste
   * @param psicologo un objeto psicologo
   * @return un objeto psicologo
   */

  @Override
  public Psicologo save(Psicologo psicologo) {
    return repo.save(psicologo);
  }

  /**
   * Funcion que sirve para actualizar un psicologo determinado a partir de su ID
   * @param id número de indentificación del psicologo
   * @param psicologo un objeto psicologo
   * @return un objeto psicologo
   * @deprecated
   */

  @Override
  public Psicologo update(Integer id, Psicologo psicologo) {
    return null;
  }

  /**
   * Funcion que elimina logicamente un psicologo mediante su numero de identificacion
   * @param id numero de identificación
   */

  @Override
  public void deleteById(Integer id) {
    Psicologo psicologo;
    if (id > 0) {
      psicologo = repo.findById(id).orElseThrow();
      psicologo.setEliminado(true);
      repo.save(psicologo);
    }
  }

  /**
   * Funcion que retorna un psicologo a partir de su dni
   * @param dni numero de dni
   * @return un psicologo
   */
  public Psicologo getByDni(Integer dni){
    return repo.findByDni(dni).orElseThrow();
  }

  @Override
  public Page<Psicologo> getPageData(int page, int pageSize) {
    return null;
  }
}
