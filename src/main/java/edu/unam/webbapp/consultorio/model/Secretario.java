package edu.unam.webbapp.consultorio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "secretario")
public class Secretario extends Persona implements Serializable {

  @Serial private static final long serialVersionUID = 6504581894234963026L;
}
