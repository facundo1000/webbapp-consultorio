package edu.unam.webbapp.consultorio.model;

import edu.unam.webbapp.consultorio.utils.TipoDocumento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "derivacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Derivacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "derivacion_id")
    private Integer idDerivacion;

    @Column(name = "nombre_dest")
    private String nombreDestinatario;

    @Column(name = "apellido_dest")
    private String apellidoDestinatario;

    @Column(name = "tipo_doc_dest")
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocDestinatario;

    @Column(name = "dni_dest")
    private Integer dniDestinatario;

    @Column(name = "clinica_dest")
    private String clinicaDestinataria;

    @Column(name = "tel_clinica_dest")
    private String telClinicaDestinataria;

    @Column(name = "direc_clinica_dest")
    private String direccionClinicaDestinataria;

    @ManyToOne
    private Psicologo psicologoEmisor;

    private String descripcion;

    @OneToOne
    private Paciente paciente;
}
