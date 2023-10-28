package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.TipoDeDescripcion;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "informeSesion")
public class InformeSesion {

    //TODO: Solucionar validacion con id.
    //Identificador unico de un informe
    @Id
    @NotNull
    @Min(9)
    private Integer idInforme;

    //Fecha de la sesion
    @Column(name = "fecha_informe")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate fechaSesion;

    //Hora de la sesion
    @Column(name = "hora_informe")
    @PastOrPresent
    @NotNull
    private LocalTime horaSesion;


    @NotEmpty
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoDeDescripcion tipoDeDescripcion;

    /**
     * <p>
     *   Valor que justifica si la sesion a sido eliminada,
     *   o no.
     * </p>
     */
    private Boolean eliminado;

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
}
