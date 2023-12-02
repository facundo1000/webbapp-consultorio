
package edu.unam.webbapp.consultorio.models;


import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Sesion;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


/**
 * Test unitario de clase Psicologo
 */
class PsicologoTest {

    @Test
    void testAddRemovePaciente() {
        // Arrange (Peparacion)
        Psicologo psicologo = new Psicologo();
        Paciente paciente = new Paciente();

        // Act (Actuacion)
        psicologo.addPaciente(paciente);

        // Assert (Verificacion)
        assertTrue(psicologo.getPacientes().contains(paciente));

        // Act (Actuacion)
        psicologo.removePaciente(paciente);

        // Assert (Verificacion)
        assertFalse(psicologo.getPacientes().contains(paciente));
    }

    @Test
    void testAddRemoveSesion() {
        // Arrange (Preparacion)
        Psicologo psicologo = new Psicologo();
        Sesion sesion = new Sesion();

        // Act (Actuacion)
        psicologo.addSesion(sesion);

        // Assert (Verificacion)
        assertTrue(psicologo.getSesions().contains(sesion));

        // Act (Actuacion)
        psicologo.removeSesion(sesion);

        // Assert (Verificacion)
        assertFalse(psicologo.getSesions().contains(sesion));
    }

    @Test
    void testRemoveAllPacientes() {
        // Arrange (Preparacion)
        Psicologo psicologo = new Psicologo();
        Paciente paciente1 = new Paciente();
        Paciente paciente2 = new Paciente();
        psicologo.addPaciente(paciente1);
        psicologo.addPaciente(paciente2);

        // Act (Actaucion)
        psicologo.removeAllPacientes();

        // Assert (Verificacion)
        assertTrue(psicologo.getPacientes().isEmpty());
    }

    @Test
    void testRemoveAllSesions() {
        // Arrange (Preparacion)
        Psicologo psicologo = new Psicologo();
        Sesion sesion1 = new Sesion();
        Sesion sesion2 = new Sesion();
        psicologo.addSesion(sesion1);
        psicologo.addSesion(sesion2);

        // Act (Actuacion)
        psicologo.removeAllSesions();

        // Assert (Verificacion)
        assertTrue(psicologo.getSesions().isEmpty());
    }

}
