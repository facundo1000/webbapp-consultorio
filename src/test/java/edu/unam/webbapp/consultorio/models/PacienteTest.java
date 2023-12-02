package edu.unam.webbapp.consultorio.models;

import edu.unam.webbapp.consultorio.utils.EstadoCivil;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.model.Sesion;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario de clase Paciente
 */
class PacienteTest {

  @Test
  void testAddSesion() {
    // Arrange (Preparacion)
    Paciente paciente = new Paciente();
    Sesion sesion = new Sesion();

    // Act (Actuacion)
    paciente.addSesion(sesion);

    // Assert (Verificacion)
    assertTrue(paciente.getSesions().contains(sesion));
  }

  @Test
  void testRemoveSesion() {
    // Arrange (Preparacion)
    Paciente paciente = new Paciente();
    Sesion sesion = new Sesion();
    paciente.addSesion(sesion);

    // Act (Actuacion)
    paciente.removeSesion(sesion);

    // Assert (Verificacion)
    assertFalse(paciente.getSesions().contains(sesion));
  }


  @Test
  void testGetterAndSetter() {
    // Arrange (Preparacion)
    Paciente paciente = new Paciente();
    EstadoCivil estadoCivil = EstadoCivil.SOLTERO;
    String ocupacion = "Estudiante";
    Psicologo psicologo = new Psicologo();
    Set<Sesion> sesiones = new HashSet<>();

    // Act (Actuacion)
    paciente.setEstadoCivil(estadoCivil);
    paciente.setOcupacion(ocupacion);
    paciente.setPsicologo(psicologo);
    paciente.setSesions(sesiones);

    // Assert (Verificacion)
    assertEquals(estadoCivil, paciente.getEstadoCivil());
    assertEquals(ocupacion, paciente.getOcupacion());
    assertEquals(psicologo, paciente.getPsicologo());
    assertEquals(sesiones, paciente.getSesions());
  }

}
