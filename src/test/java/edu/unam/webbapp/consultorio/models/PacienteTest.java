package edu.unam.webbapp.consultorio.models;

import static edu.unam.webbapp.consultorio.utils.PojoGenerator.buildAlumno;
import static edu.unam.webbapp.consultorio.utils.PojoGenerator.buildSesion;
import static org.assertj.core.api.Assertions.assertThat;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.model.Sesion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class PacienteTest {
  private static Paciente paciente;
  private static Sesion sesion;

  @BeforeAll
  static void setUp() {
    paciente = buildAlumno();
    sesion = buildSesion();
  }

//  private final Sesion sesion2 =
//      new Sesion(
//          26,
//          LocalDate.of(2023, Month.AUGUST, 15),
//          LocalTime.of(10, 00),
//          new Psicologo(),
//          null,
//          false);

  @Test
  @DisplayName("Test: agregar sesiones al paciente")
  void agregarSesiones() {

    paciente.addSesion(sesion);
//    paciente.addSesion(sesion2);

    assertThat(paciente.getSesions()).hasSize(3);

  }

  @Test
  @DisplayName("Test: remover sesion del paciente")
  void removerSesiones() {
    paciente.removeSesion(sesion);
//    paciente.removeSesion(sesion2);
    paciente.removeSesion(null);
    assertThat(paciente.getSesions()).hasSize(1);
  }
}
