package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.repository.PacienteRepositorio;
import edu.unam.webbapp.consultorio.services.PersonaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PersonaService<Paciente> {

  private final PacienteRepositorio repo;
  private final PersonaService<Psicologo> psicoService;

  @Override
  public List<Paciente> findAll() {
    return repo.findAll();
  }

  @Override
  public Paciente getById(Integer id) {
    return repo.findById(id).orElseThrow();
  }

  @Override
  public Paciente save(Paciente paciente) {
    return repo.save(paciente);
  }

  public List<Paciente> getAllEliminadoEquals(Boolean eliminado) {
    return repo.findAllByEliminadoEquals(eliminado);
  }

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

  @Override
  public void deleteById(Integer id) {
    Paciente pc = repo.findById(id).orElseThrow();
    pc.setEliminado(true);
    repo.save(pc);
  }
}
