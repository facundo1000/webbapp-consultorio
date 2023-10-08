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

@Getter
@Setter
@NoArgsConstructor
@Table(name = "persona")
@MappedSuperclass
public class Persona implements Serializable {

  //TODO: solucionar validacion con dni
  @Id
  @NotNull
  @Min(9) //no entiendo porque me permite solo este valor de restriccion
  private Integer dni;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_doc")
  @NotNull
  private TipoDocumento tipoDoc;

  @NotEmpty
  @Column(length = 30)
  @Size(min = 2, max = 20)
  private String nombre;
  @NotEmpty
  @Column(length = 30)
  @Size(min = 2, max = 20)
  private String apellido;
  @NotEmpty
  @Column(length = 100)
  private String telefono;
  @NotEmpty
  @Column(length = 150)
  private String direccion;

  @Enumerated(EnumType.STRING)
  @NotNull
  private Sexo sexo;

  @Column(name = "fecha_de_nacimiento")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull
  private LocalDate fechaDeNacimiento;

  private Boolean eliminado;

  @PrePersist
  public void prePersist(){
    eliminado = Boolean.FALSE;
  }

  @Serial private static final long serialVersionUID = -4460821043280056762L;
}
