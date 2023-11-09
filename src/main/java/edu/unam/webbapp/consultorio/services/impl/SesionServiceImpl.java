package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.repository.SesionRepositorio;
import edu.unam.webbapp.consultorio.services.SesionService;
import edu.unam.webbapp.consultorio.utils.EstadosSesion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase SesionServiceImpl
 *
 * @author Andre, Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Service
@RequiredArgsConstructor
public class SesionServiceImpl implements SesionService {

    private final SesionRepositorio repo;

    /**
     * Función que retorna una lista de sesiones
     *
     * @return lista de sesiones
     */
    @Override
    public List<Sesion> findAll() {
        return repo.findAll();
    }

    /**
     * Función que retorna un objeto sesion
     *
     * @param id número de identificación
     * @return un objeto sesion
     */

    @Override
    public Sesion findById(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    /**
     * Función que retorna un objeto sesion
     *
     * @param sesion un objeto sesion
     * @return un objeto sesion
     */

    @Override
    public Sesion save(Sesion sesion) {
        return repo.save(sesion);
    }

    /**
     * Función que actualiza un objeto sesion
     *
     * @param id     un número de identificación de sesion
     * @param sesion un objeto sesion
     * @return un objeto sesion modificado
     */

    @Override
    public Sesion update(Integer id, Sesion sesion) {
        return null;
    }

    /**
     * Función que obtiene una lista de sesiones a partir de un paciente
     *
     * @param id número identificación de un paciente
     * @return lista de sesiones por paciente
     */
    @Override
    public List<Sesion> findSesionByPacienteId(Integer id) {
        return repo.findSesionsByPacienteDni(id);
    }

    /**
     * Función que elimina lógicamente una sesion
     *
     * @param id número de identificación de una sesion
     */
    @Override
    public void deleteById(Integer id) {
        Sesion sesion = repo.findById(id).orElseThrow();
        sesion.setEliminado(true);
    }


    @Override
    public Sesion sesionStatus(LocalDate fecha, Sesion sesion) {
        if (fecha.isAfter(LocalDate.now()) || fecha.isEqual(LocalDate.now())) {
            sesion.setEstadosSesion(EstadosSesion.PENDIENTE);
        }

        /**
         * TODO:
         *  Esto deberia llevar un metodo un metodo un metodo automatico que esté pendiente del horario del sistema.
         *  para que la realizacion se pueda hacer de forma manual o de forma automatica
         */

        if (fecha.isBefore(LocalDate.now())) {
            sesion.setEstadosSesion(EstadosSesion.REALIZADA);
        }
        return sesion;
    }
}
