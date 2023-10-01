package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.EstadoCivil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "paciente")
public class Paciente extends Persona {

  @Column(name = "estado_civil")
  @Enumerated(EnumType.STRING)
  private EstadoCivil estadoCivil;

  private String ocupacion;
}
