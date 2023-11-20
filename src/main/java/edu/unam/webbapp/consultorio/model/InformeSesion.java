package edu.unam.webbapp.consultorio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
/**
 * Clase InformeSesion
 * @author Andre,Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "informe_sesion")
public class InformeSesion {

    @Id
    @Column(name = "id_informe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInforme;

    //Fecha de la sesion
    @Column(name = "fecha_informe")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSesion;

    //Hora de la sesion
    @Column(name = "hora_informe")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaSesion;

    private String analisis;

    private String notas;

    private String conclusion;

    private String tareas;

    @OneToOne
    @JoinColumn(name = "sesion_id")
    private Sesion sesion;

    @ManyToOne
    @JoinColumn(name = "historia_id")
    private HistoriaClinica historia;


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
        fechaSesion = LocalDate.now();
        horaSesion = LocalTime.now();
    }


}
