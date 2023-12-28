package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.EstadosSesion;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Clase Sesion
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sesion")
public class Sesion implements Serializable {

  /**
   * Numero que identifica una sesion
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "nro_sesion")
  @NotNull
  private Integer nroSesion;

  /**
   * Fecha en la cual se hará la sesion
   */
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha;

  /**
   * Hora en la cual se hará la sesion
   */
  @NotNull
  @DateTimeFormat(pattern = "HH:mm")
  private LocalTime hora;

  /**
   * Psicologo asociado a una determinada sesion
   */
  @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private Psicologo psicologo;

  /**
   * Paciente asociada a una determinado sesion
   */

  @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
  @NotNull
  private Paciente paciente;

  @OneToOne(mappedBy = "sesion")
  private InformeSesion informeSesion;

  /**
   * <p>
   *   Valor que justifica si la sesion a sido eliminada,
   *   o no.
   * </p>
   */
  private Boolean eliminado;

  @NotNull
  @Column(name = "estado")
  @Enumerated(EnumType.STRING)
  private EstadosSesion estadosSesion;

  /**
   * <p>
   *  Metodo que configura por defecto
   *  el valor de 'falso' antes que se persista
   *  una entidad en una base de datos
   * </p>
   */
  @PrePersist
  public void prePersist() {
    eliminado = Boolean.FALSE;
  }

  @Serial private static final long serialVersionUID = 6504581894234963026L;
}
