package edu.unam.webbapp.consultorio.models;

import edu.unam.webbapp.consultorio.model.Persona;
import edu.unam.webbapp.consultorio.utils.Sexo;
import edu.unam.webbapp.consultorio.utils.TipoDocumento;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test unitario de clase Persona
 */
class PersonaTest {

    @Test
    void testGetterAndSetter() {
        // Arrange (Preparacion)
        Persona persona = new Persona();
        int dni = 123456789;
        TipoDocumento tipoDocumento = TipoDocumento.DNI;
        String nombre = "John";
        String apellido = "Doe";
        String telefono = "123456789";
        String direccion = "Calle Principal";
        Sexo sexo = Sexo.MASCULINO;
        LocalDate fechaNacimiento = LocalDate.of(1990, 1, 1);


        // Act (Actuacion)
        persona.setDni(dni);
        persona.setTipoDoc(tipoDocumento);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setTelefono(telefono);
        persona.setDireccion(direccion);
        persona.setSexo(sexo);
        persona.setFechaDeNacimiento(fechaNacimiento);

        // Assert (Verificacion)
        assertEquals(dni, persona.getDni());
        assertEquals(tipoDocumento, persona.getTipoDoc());
        assertEquals(nombre, persona.getNombre());
        assertEquals(apellido, persona.getApellido());
        assertEquals(telefono, persona.getTelefono());
        assertEquals(direccion, persona.getDireccion());
        assertEquals(sexo, persona.getSexo());
        assertEquals(fechaNacimiento, persona.getFechaDeNacimiento());
    }

}
