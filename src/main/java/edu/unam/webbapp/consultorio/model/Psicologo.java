package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.Especialidad;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "psicologo")
public class Psicologo extends Persona implements Serializable {

  @Enumerated(EnumType.STRING)
  private Especialidad especialidad;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "tbl_paciente_psicologo",
      joinColumns = @JoinColumn(name = "psicologo_id"),
      inverseJoinColumns = @JoinColumn(name = "paciente_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"psicologo_id", "paciente_id"}))
  private Set<Paciente> pacientes;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "tbl_psicologo_sesion",
      joinColumns = @JoinColumn(name = "psicologo_id"),
      inverseJoinColumns = @JoinColumn(name = "sesion_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"psicologo_id", "sesion_id"}))
  private Set<Sesion> sesions;

  public void addPaciente(Paciente paciente) {
    this.pacientes.add(paciente);
  }

  public void addSesion(Sesion sesion) {
    this.sesions.add(sesion);
  }

  public void removePaciente(Paciente paciente) {
    this.pacientes.remove(paciente);
  }

  public void removeSesion(Sesion sesion) {
    this.sesions.remove(sesion);
  }

  public void removeAllPacientes() {
    for (Paciente p : pacientes) {
      removePaciente(p);
    }
  }

  public void removeAllSesions() {
    for (Sesion s : sesions) {
      removeSesion(s);
    }
  }

  @Serial private static final long serialVersionUID = 5396190148242599611L;
}
