package edu.unam.webbapp.consultorio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "psicologo")
public class Psicologo extends Persona{
    private String especialidad;
}
