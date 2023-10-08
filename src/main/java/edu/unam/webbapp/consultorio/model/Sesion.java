package edu.unam.webbapp.consultorio.model;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sesion")
public class Sesion implements Serializable {

  @Id
  @Setter(AccessLevel.NONE)
  @Column(name = "nro_sesion")
  @NotNull
  private Integer nroSesion;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha;

  @NotNull
  private LocalTime hora;

  @ManyToOne
  private Psicologo psicologo;

  @ManyToOne
  private Paciente paciente;

  private Boolean eliminado;

  @Serial private static final long serialVersionUID = 6504581894234963026L;
}
