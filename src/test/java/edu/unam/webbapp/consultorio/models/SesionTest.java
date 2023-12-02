package edu.unam.webbapp.consultorio.models;

import edu.unam.webbapp.consultorio.utils.EstadosSesion;
import org.junit.jupiter.api.Test;
import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.InformeSesion;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test unitario de clase Sesion
 */
class SesionTest {

    @Test
    void testPrePersist() {
        // Arrange (Preparacion)
        Sesion sesion = new Sesion();

        // Act (Actuacion)
        sesion.prePersist();

        // Assert (Verificacion)
        assertFalse(sesion.getEliminado());
    }

    @Test
    void testGetterAndSetter() {
        // Arrange (Preparacion)
        Sesion sesion = new Sesion();
        Integer nroSesion = 13;
        LocalDate fecha = LocalDate.of(2023, 12, 1);
        LocalTime hora = LocalTime.of(17, 00);
        Psicologo psicologo = new Psicologo();
        Paciente paciente = new Paciente();
        InformeSesion informeSesion = new InformeSesion();
        Boolean eliminado = false;
        EstadosSesion estadosSesion = EstadosSesion.REALIZADA;

        // Act (Actuacion)
        sesion.setNroSesion(nroSesion);
        sesion.setFecha(fecha);
        sesion.setHora(hora);
        sesion.setPsicologo(psicologo);
        sesion.setPaciente(paciente);
        sesion.setInformeSesion(informeSesion);
        sesion.setEliminado(eliminado);
        sesion.setEstadosSesion(estadosSesion);

        // Assert (Verificacion)
        assertEquals(nroSesion, sesion.getNroSesion());
        assertEquals(fecha, sesion.getFecha());
        assertEquals(hora, sesion.getHora());
        assertEquals(psicologo, sesion.getPsicologo());
        assertEquals(paciente, sesion.getPaciente());
        assertEquals(informeSesion, sesion.getInformeSesion());
        assertEquals(eliminado, sesion.getEliminado());
        assertEquals(estadosSesion, sesion.getEstadosSesion());
    }

}
