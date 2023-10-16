package edu.unam.webbapp.consultorio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sesion")
public class Sesion implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
  @NotNull
  private Paciente paciente;

  private Boolean eliminado;

  @PrePersist
  public void prePersist() {
    eliminado = Boolean.FALSE;
  }

  @Serial private static final long serialVersionUID = 6504581894234963026L;
}
