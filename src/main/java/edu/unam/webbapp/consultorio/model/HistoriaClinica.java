package edu.unam.webbapp.consultorio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Clase Historia Clinica
 *
 * @author Andre, Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "historia_clinica")
public class HistoriaClinica implements Serializable {

    @Id
    @Column(name = "historia_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historiaId;

    @Column(name = "cant_sesiones")
    private Integer cantSesiones;

    @OneToMany
    @JoinTable(
            name = "tbl_informe_historia",
            joinColumns = @JoinColumn(name = "historia_id"),
            inverseJoinColumns = @JoinColumn(name = "informe_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"historia_id", "informe_id"}))
    List<InformeSesion> informeSesions;

    public void agregarInforme(InformeSesion informe) {
        informeSesions.add(informe);
    }

    public void removerInforme(InformeSesion informe) {
        informeSesions.remove(informe);
    }


    @Serial
    private static final long serialVersionUID = -5504179437638662318L;

}
