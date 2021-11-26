/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Repositorio;

import Retos.Interface.InterfaceReservacion;
import Retos.Modelo.Cliente;
import Retos.Modelo.Custom.Auxiliar;
import Retos.Modelo.Reservacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 57300
 */
@Repository
public class RepositorioReservacion {
    @Autowired
    private InterfaceReservacion crud4;
    
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud4.findAll();
    }
    public Optional<Reservacion> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservacion save(Reservacion reservation){
        return crud4.save(reservation);
    }
     public void delete(Reservacion reservacion){
        crud4.delete(reservacion);
    }

     public List<Reservacion> getReservacionesByStatus(String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<Reservacion> getReservacionesByPeriod(Date dateOne, Date dateTwo){
         return crud4.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
     }
     
     public List<Auxiliar> getTopCliente (){
         List<Auxiliar> lista = new ArrayList<>(); 
         
         List<Object[]> reporte = crud4.countTotalReservacionByClient();
         for(int i = 0;i<reporte.size();i++){
             Cliente client = (Cliente) reporte.get(i)[0];
             Long cantidad = (Long) reporte.get(i)[1];
             Auxiliar cc = new Auxiliar(cantidad,client);
             lista.add(cc);
         }
         return lista;
     }
}
