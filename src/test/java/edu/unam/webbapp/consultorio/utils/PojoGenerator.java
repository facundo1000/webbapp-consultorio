package edu.unam.webbapp.consultorio.utils;

import edu.unam.webbapp.consultorio.model.Paciente;
import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.model.Sesion;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class PojoGenerator {
  public static Paciente buildAlumno() {
    Paciente paciente = new Paciente();
    paciente.setTipoDoc(TipoDocumento.DNI);
    paciente.setDni(40123654);
    paciente.setNombre("francisco");
    paciente.setApellido("roman");
    paciente.setFechaDeNacimiento(LocalDate.of(1999, Month.DECEMBER, 23));
    paciente.setEliminado(false);
    paciente.setTelefono("2953453216");
    paciente.setDireccion("pellegrini 554");
    paciente.setPsicologo(new Psicologo());
    paciente.setOcupacion("pianista");
    paciente.addSesion(null);
    paciente.setEstadoCivil(EstadoCivil.CASADO);
    return paciente;
  }


  public static Sesion buildSesion(){
    return Sesion.builder()
            .nroSesion(20)
            .fecha(LocalDate.of(2023,Month.JANUARY,10))
            .hora(LocalTime.of(16,30))
            .paciente(null)
            .psicologo(new Psicologo())
            .eliminado(false)
            .build();
  }


}
