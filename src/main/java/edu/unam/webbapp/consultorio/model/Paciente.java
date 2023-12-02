package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.EstadoCivil;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Clase Paciente
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paciente")
public class Paciente extends Persona implements Serializable {

  /**
   * Estado Civil del paciente
   */

  @Column(name = "estado_civil")
  @Enumerated(EnumType.STRING)
  @NotNull
  private EstadoCivil estadoCivil;

  /**
   * Ocupacion del paciente
   */

  @NotEmpty
  private String ocupacion;

  /**
   * Psicologo asignado al paciente
   */

  @ManyToOne
  @NotNull
  private Psicologo psicologo;

  /**
   * Sesiones asignadas al paciente
   */
  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "tbl_paciente_sesion",
      joinColumns = @JoinColumn(name = "paciente_id"),
      inverseJoinColumns = @JoinColumn(name = "sesion_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"paciente_id", "sesion_id"}))
  private Set<Sesion> sesions = new HashSet<>();


  @OneToOne
  private Derivacion derivacion;


  /**
   * Funcion para agregar una sesion a la lista de sesiones
   * @param sesion un objeto sesion
   */

  public void addSesion(Sesion sesion) {
    this.sesions.add(sesion);
  }

  /**
   * Funcion para remover una sesion de una lista de sesiones
   * @param sesion un objeto sesion
   */

  public void removeSesion(Sesion sesion) {
    this.sesions.remove(sesion);
  }

  /**
   * Funcion para remover todas las sesiones de la lista de sesiones
   */

  public void removeAllSesions(){
    for (Sesion s : sesions) {
        removeSesion(s);
    }
  }

  @Serial private static final long serialVersionUID = -2165208220281546948L;
}
