/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Servicio;

import Retos.Modelo.Custom.Auxiliar;
import Retos.Modelo.Custom.Auxiliar2;
import Retos.Modelo.Reservacion;
import Retos.Repositorio.RepositorioReservacion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase empleada para usar los servicios Crud del repository
 * @author 57300
 */
@Service
public class ServicioReservacion {
    @Autowired
    /**
     * parametro para implementacion de metodos crud
     * @param parametro empleado para usar los metodos crud del repositorio
     */
    private RepositorioReservacion metodosCrud;
    /**
     * Fundion empleada para traer todas las reservas
     * @return Todas las reservas registradas
     */
    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }
/**
 * Funcion empleada para llamar a una reservacion por su id
 * @param reservationId Id de la reservacion a llamar
 * @return Reservacion obtenida por id
 */
    public Optional<Reservacion> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
/**
 * Funcion empleada para guardar reservaciones, para ello usamos un objeto de la clase reservation
 * @param reservation objeto de la clase reservation a guardar como reservacion
 * @return objeto reservacion guardada
 */
    public Reservacion save(Reservacion reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservacion> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    /**
     * funcion empleada para editar reservaciones por id
     * @param reservacion contiene los parametros del objeto reservation a modificar, incluyendo el id
     * @return el objeto reservation editado
     */
public Reservacion update(Reservacion reservacion){
        if(reservacion.getIdReservation()!=null){
            Optional<Reservacion> e= metodosCrud.getReservation(reservacion.getIdReservation());
            if(!e.isEmpty()){

                if(reservacion.getStartDate()!=null){
                    e.get().setStartDate(reservacion.getStartDate());
                }
                if(reservacion.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if(reservacion.getStatus()!=null){
                    e.get().setStatus(reservacion.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservacion;
            }
        }else{
            return reservacion;
        }
    }

    /**
     * Fundion empleada para eliminar registros por id
     * @param reservationId Id del registro a eliminar
     * @return true si se elimino el registro con exito, false si no se pudo realizar la accion de eliminar el registro
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Auxiliar> getTopCliente(){
        return metodosCrud.getTopCliente();
    }
    
    public Auxiliar2 getstatusReport(){
        List<Reservacion> completed = metodosCrud.getReservacionesByStatus("completed");
        List<Reservacion> cancelled = metodosCrud.getReservacionesByStatus("cancelled");
        
        Auxiliar2 status = new Auxiliar2(completed.size(), cancelled.size());
        return status;
    }
    
    public List<Reservacion> getReservasPeriodo(String d1, String d2){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        
        try {
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return metodosCrud.getReservacionesByPeriod(dateOne, dateTwo);
        }else{
            return new ArrayList<>();
        }
        
    }
}
