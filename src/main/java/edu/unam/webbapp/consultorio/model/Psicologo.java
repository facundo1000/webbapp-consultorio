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

/**
 * Clase Psicologo
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "psicologo")
public class Psicologo extends Persona implements Serializable {

  /**
   * Especialidad que corresponde a un determinado psicologo
   */

  @Enumerated(EnumType.STRING)
  private Especialidad especialidad;

  /**
   * Lista de pacientes que corresponden a cada
   * paciente que atiende un determinado psicologo
   */

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "tbl_paciente_psicologo",
      joinColumns = @JoinColumn(name = "psicologo_id"),
      inverseJoinColumns = @JoinColumn(name = "paciente_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"psicologo_id", "paciente_id"}))
  private Set<Paciente> pacientes;

  /**
   * Lista de sesiones que corresponden a un determinado psicologo
   */

  @OneToMany()
  @JoinTable(
      name = "tbl_psicologo_sesion",
      joinColumns = @JoinColumn(name = "psicologo_id"),
      inverseJoinColumns = @JoinColumn(name = "sesion_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"psicologo_id", "sesion_id"}))
  private Set<Sesion> sesions;

  @OneToMany
  @JoinTable(
          name = "tbl_psicologo_derivaciones",
          joinColumns = @JoinColumn(name = "psicologo_id"),
          inverseJoinColumns = @JoinColumn(name = "derivacion_id"),
          uniqueConstraints = @UniqueConstraint(columnNames = {"psicologo_id", "derivacion_id"}))
  private List<Derivacion> derivacions;

  /**
   * Funcion que agrega un paciente a una lista
   * @param paciente un objeto paciente
   */

  public void addPaciente(Paciente paciente) {
    this.pacientes.add(paciente);
  }

  /**
   * Funcion que agrega una sesion a una lista
   * @param sesion un objeto sesion
   */

  public void addSesion(Sesion sesion) {
    this.sesions.add(sesion);
  }

  /**
   * Funcion que remueve un paciente de la lista de pacientes
   * @param paciente un objeto paciente
   */
  public void removePaciente(Paciente paciente) {
    this.pacientes.remove(paciente);
  }

  /**
   * Funcion que agrega una sesion a una lista de sesiones
   * @param sesion un objeto sesion
   */

  public void removeSesion(Sesion sesion) {
    this.sesions.remove(sesion);
  }

  /**
   * Funcion que remueve todos los pacientes de
   * una lista de pacientes
   */
  public void removeAllPacientes() {
    for (Paciente p : pacientes) {
      removePaciente(p);
    }
  }

  /**
   * Funcion que remueve todos las sesiones de una
   * lista de sesiones
   */

  public void removeAllSesions() {
    for (Sesion s : sesions) {
      removeSesion(s);
    }
  }

  public void agregarDerivacion(Derivacion derivacion){
    this.derivacions.add(derivacion);
  }

  public void removerDerivacion(Derivacion derivacion){
    this.derivacions.remove(derivacion);
  }

  @Serial private static final long serialVersionUID = 5396190148242599611L;
}
