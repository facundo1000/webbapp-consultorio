package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.Sexo;
import edu.unam.webbapp.consultorio.utils.TipoDocumento;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Clase Persona (clase padre)
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */

@Getter
@Setter
@NoArgsConstructor
@Table(name = "persona")
@MappedSuperclass
public class Persona implements Serializable {

  /**
   * Numero de dni que corresponde a cada persona
   */

  //TODO: solucionar validacion con dni
  @Id
  @NotNull
  @Min(9) //no entiendo porque me permite solo este valor de restriccion
  private Integer dni;

  /**
   * Tipo de documento correspondiente a una persona
   */

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_doc")
  @NotNull
  private TipoDocumento tipoDoc;

  /**
   * Nombre de una persona determinada
   */

  @NotEmpty
  @Column(length = 30)
  @Size(min = 2, max = 20)
  private String nombre;

  /**
   * Apellido de una persona determinada
   */

  @NotEmpty
  @Column(length = 30)
  @Size(min = 2, max = 20)
  private String apellido;

  /**
   * Telefono de una persona de una persona determinada
   */

  @NotEmpty
  @Column(length = 100)
  private String telefono;

  /**
   * Direccion de una persona determinada
   */
  @NotEmpty
  @Column(length = 150)
  private String direccion;

  /**
   * Sexo de una persona de terminada
   */
  @Enumerated(EnumType.STRING)
  @NotNull
  private Sexo sexo;

  /**
   * Fecha de nacimiento de una persona determinada
   */

  @Column(name = "fecha_de_nacimiento")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull
  private LocalDate fechaDeNacimiento;

  /**
   * Valor para determinar si la persona
   * ha sido eliminado logicamente
   */

  private Boolean eliminado;

  @PrePersist
  public void prePersist(){
    eliminado = Boolean.FALSE;
  }

  @Serial private static final long serialVersionUID = -4460821043280056762L;
}
