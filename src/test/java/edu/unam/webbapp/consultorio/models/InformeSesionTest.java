package edu.unam.webbapp.consultorio.models;

import org.junit.jupiter.api.Test;

import edu.unam.webbapp.consultorio.model.InformeSesion;
import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.model.HistoriaClinica;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test unitario de clase InformeSesion
 */
class InformeSesionTest {

    @Test
    void testPrePersist() {
        // Arrange
        InformeSesion informeSesion = new InformeSesion();

        // Act
        informeSesion.prePersist();

        // Assert
        assertFalse(informeSesion.getEliminado());
        assertNotNull(informeSesion.getFechaSesion());
        assertNotNull(informeSesion.getHoraSesion());
    }

    @Test
    void testGetterAndSetter() {
        // Arrange (Preparacion)
        InformeSesion informeSesion = new InformeSesion();
        Integer idInforme = 1;
        LocalDate fechaSesion = LocalDate.of(2023, 12, 1);
        LocalTime horaSesion = LocalTime.of(12, 30);
        String analisis = "Análisis de la sesión";
        String notas = "Notas de la sesión";
        String conclusion = "Conclusión de la sesión";
        String tareas = "Tareas pendientes";
        Sesion sesion = new Sesion();
        HistoriaClinica historiaClinica = new HistoriaClinica();

        // Act (Actuacion)
        informeSesion.setIdInforme(idInforme);
        informeSesion.setFechaSesion(fechaSesion);
        informeSesion.setHoraSesion(horaSesion);
        informeSesion.setAnalisis(analisis);
        informeSesion.setNotas(notas);
        informeSesion.setConclusion(conclusion);
        informeSesion.setTareas(tareas);
        informeSesion.setSesion(sesion);
        informeSesion.setHistoria(historiaClinica);

        // Assert (Verificacion)
        assertEquals(idInforme, informeSesion.getIdInforme());
        assertEquals(fechaSesion, informeSesion.getFechaSesion());
        assertEquals(horaSesion, informeSesion.getHoraSesion());
        assertEquals(analisis, informeSesion.getAnalisis());
        assertEquals(notas, informeSesion.getNotas());
        assertEquals(conclusion, informeSesion.getConclusion());
        assertEquals(tareas, informeSesion.getTareas());
        assertEquals(sesion, informeSesion.getSesion());
        assertEquals(historiaClinica, informeSesion.getHistoria());
    }

}
