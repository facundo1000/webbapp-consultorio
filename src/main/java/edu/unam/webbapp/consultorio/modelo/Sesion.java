package edu.unam.webbapp.consultorio.modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *Sesion realizada por un paciente en el consultorio.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sesion {
    /**
     * Identificador unico de una sesion.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)

    private Integer nroSesion;


    /**
     * Fecha en la que se realiza la sesion.
     */

    @NotBlank
    @Column(nullable = false)
    private LocalDate fecha;

    @NotBlank
    @Column(nullable = false)
    private LocalTime hora;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String psicologo;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String paciente;


}
