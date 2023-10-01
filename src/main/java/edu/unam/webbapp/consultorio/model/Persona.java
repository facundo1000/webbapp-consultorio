package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.Sexo;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "persona")
@MappedSuperclass
public class Persona {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer dni;

  private String nombre;
  private String apellido;
  private String telefono;
  private String direccion;

  @Enumerated(EnumType.STRING)
  private Sexo sexo;

  @Column(name = "fecha_de_nacimiento")
  private LocalDate fechaDeNacimiento;

  private Boolean eliminado;
}
