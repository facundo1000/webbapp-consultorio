package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.repository.PacienteRepositorio;
import edu.unam.webbapp.consultorio.services.PersonaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Clase PacienteServiceImpl
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PersonaService<Paciente> {

  private final PacienteRepositorio repo;

  /**
   * Función que retorna una lista de pacientes
   * @return lista de pacientes
   */
  @Override
  public List<Paciente> findAll() {
    return repo.findAll();
  }

  /**
   * Función para obtener un paciente a partir de su número de identificación
   * @param id numero de identificacion
   * @return un objeto paciente
   */

  @Override
  public Paciente getById(Integer id) {
    return repo.findById(id).orElseThrow();
  }

  /**
   * Funcion para persistir un objeto
   * @param paciente un objeto
   * @return un objeto paciente
   */
  @Override
  public Paciente save(Paciente paciente) {
    return repo.save(paciente);
  }

  /**
   * Funcion para obtener una lista de pacientes respecto si estan eliminados o no
   * @param eliminado true o false
   * @return lista de pacientes que fueron o no eliminados
   */
  public List<Paciente> getAllEliminadoEquals(Boolean eliminado) {
    return repo.findAllByEliminadoEquals(eliminado);
  }

  /**
   * Funcion que actualiza un objeto paciente a partir de su numero de identificacion
   * @param id número de indentificación
   * @param paciente un objeto
   * @return un objeto paciente
   */
  @Override
  public Paciente update(Integer id, Paciente paciente) {
    Paciente pc = repo.findById(id).orElseThrow();
    pc.setNombre(paciente.getNombre());
    pc.setApellido(paciente.getApellido());
    pc.setDireccion(paciente.getDireccion());
    pc.setFechaDeNacimiento(paciente.getFechaDeNacimiento());
    pc.setOcupacion(paciente.getOcupacion());
    pc.setEstadoCivil(paciente.getEstadoCivil());
    pc.setTelefono(paciente.getTelefono());
    pc.setSexo(paciente.getSexo());
    pc.setTipoDoc(paciente.getTipoDoc());
    return pc;
  }

  /**
   * Función para eliminar logicamente un paciente
   * @param id numero de identificación
   */
  @Override
  public void deleteById(Integer id) {
    Paciente pc = repo.findById(id).orElseThrow();
    pc.setEliminado(true);
    repo.save(pc);
  }

  @Override
  public Page<Paciente> getPageData(int page, int pageSize) {
    Pageable pageable = PageRequest.of(page,pageSize);
    return repo.findAll(pageable);
  }
}
