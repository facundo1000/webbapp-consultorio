package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.repository.SesionRepositorio;
import edu.unam.webbapp.consultorio.services.SesionService;
import edu.unam.webbapp.consultorio.utils.EstadosSesion;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

/**
 * Clase SesionServiceImpl
 *
 * @author Andre, Gelabert; Pavon, Gabriel; Martinez, Facundo
 */
@Service
@RequiredArgsConstructor
@Slf4j
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
        sesion.setEstadosSesion(EstadosSesion.CANCELADA);
        repo.save(sesion);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        log.info("La sesion {} se ha cancelado manualmente; Fecha: {}", sesion.getNroSesion(), LocalDateTime.now().format(df));
    }


    /**
     * Funcion que retorna un objeto sesion, a partir de una comparacion entre fechas
     *
     * @param fecha  objeto fecha
     * @param sesion objeto sesion
     * @return un objeto sesion
     */
    @Override
    public Sesion sesionStatus(LocalDate fecha, Sesion sesion, LocalTime hora) {
        if (fecha.isAfter(LocalDate.now()) || fecha.isEqual(LocalDate.now())) {

            if(hora.isAfter(LocalTime.now()) || hora.equals(LocalTime.now())){

                sesion.setEstadosSesion(EstadosSesion.PENDIENTE);
            }

        }
        return sesion;
    }

    /**
     * Funcion que permite cambiar aquellos estados de sesion que son "pendientes"
     * a estado "cancelado" luego de 24hs
     */
    @Scheduled(cron = "* 59 23 * * *")
    public void scheduleTask() {

        Optional<List<Sesion>> fechaBefore = repo.findSesionByFechaBefore(LocalDate.now());

        if (fechaBefore.isPresent()) {

            fechaBefore.orElseThrow().forEach(fecha -> {

                if (fecha.getEstadosSesion() == EstadosSesion.PENDIENTE) {

                    fecha.setEstadosSesion(EstadosSesion.CANCELADA);
                    fecha.setEliminado(true);
                    repo.save(fecha);
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    log.info("La sesion {} ha sido cancelada luego de 24 hs. Fecha de cancelacion: {}", fecha.getNroSesion(), LocalDateTime.now().format(df));
                }
            });
        }
        ;


    }

    /**
     * Funcion que permite ejecutar la funcion anotada con @Schedule
     * luego de la creacion del constructor
     */
    @PostConstruct
    public void init() {
        scheduleTask();
    }


}
