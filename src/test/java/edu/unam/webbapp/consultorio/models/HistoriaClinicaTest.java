package edu.unam.webbapp.consultorio.models;

import edu.unam.webbapp.consultorio.model.HistoriaClinica;
import edu.unam.webbapp.consultorio.model.InformeSesion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test unitario de clase HistoriaClinica
 */
class HistoriaClinicaTest {

    @Test
    void testAgregarInforme() {
        // Arrange (Preparacion)
        HistoriaClinica historiaClinica = new HistoriaClinica();
        InformeSesion informe = new InformeSesion();
        // Act (Actuacion)
        historiaClinica.agregarInforme(informe);

        // Assert (Verificacion)
        assertTrue(historiaClinica.getInformeSesions().contains(informe));
    }

    @Test
    void testRemoverInforme() {
        // Arrange (Preparacion)
        HistoriaClinica historiaClinica = new HistoriaClinica();
        InformeSesion informe = new InformeSesion();
        historiaClinica.agregarInforme(informe);

        // Act (Actuacion)
        historiaClinica.removerInforme(informe);

        // Assert (Verificacion)
        assertTrue(historiaClinica.getInformeSesions().isEmpty());
    }

    @Test
    void testCantSesiones() {
        // Arrange (Preparacion)
        HistoriaClinica historiaClinica = new HistoriaClinica();
        InformeSesion informe1 = new InformeSesion();
        InformeSesion informe2 = new InformeSesion();

        List<InformeSesion> informeSesions = new ArrayList<>();
        informeSesions.add(informe1);
        informeSesions.add(informe2);

        historiaClinica.setInformeSesions(informeSesions);

        // Act (Actuacion)
        int cantSesiones = historiaClinica.getCantSesiones();

        // Assert (Verificacion)
        assertEquals(2, cantSesiones);
    }

}

