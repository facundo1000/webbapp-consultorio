package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.TipoDeDescripcion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "informe_sesion")
public class InformeSesion {

    //TODO: Solucionar validacion con id.
    //Identificador unico de un informe
    @Id
    @NotNull
    @Column(name = "id_informe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaSesion;


    @NotEmpty
    @Column(nullable = false)
    private String analisis;

    private String notas;

    private String conclusion;

    @OneToOne
    private Sesion sesion;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "tipo_descripcion")
//    private TipoDeDescripcion tipoDeDescripcion;

    /**
     * <p>
     * Valor que justifica si la sesion a sido eliminada,
     * o no.
     * </p>
     */
    private Boolean eliminado;

    /**
     * <p>
     * Metodo que configura por defecto
     * el valor de 'falso' antes que se persista
     * una entidad en una base de datos
     * </p>
     */
    @PrePersist
    public void prePersist() {
        eliminado = Boolean.FALSE;
    }
}
