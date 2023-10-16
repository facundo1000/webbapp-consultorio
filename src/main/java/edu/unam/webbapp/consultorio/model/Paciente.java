package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.EstadoCivil;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "paciente")
public class Paciente extends Persona implements Serializable {

  @Column(name = "estado_civil")
  @Enumerated(EnumType.STRING)
  @NotNull
  private EstadoCivil estadoCivil;

  @NotEmpty
  private String ocupacion;

  @ManyToOne
  @NotNull
  private Psicologo psicologo;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "tbl_paciente_sesion",
      joinColumns = @JoinColumn(name = "paciente_id"),
      inverseJoinColumns = @JoinColumn(name = "sesion_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"paciente_id", "sesion_id"}))
  private Set<Sesion> sesions;

  public void addSesion(Sesion sesion) {
    this.sesions.add(sesion);
  }

  public void removeSesion(Sesion sesion) {
    this.sesions.remove(sesion);
  }

  public void removeAllSesions(){
    for (Sesion s : sesions) {
        removeSesion(s);
    }
  }

  @Serial private static final long serialVersionUID = -2165208220281546948L;
}
