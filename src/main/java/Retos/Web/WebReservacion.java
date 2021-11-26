/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Web;

import Retos.Modelo.Custom.Auxiliar;
import Retos.Modelo.Custom.Auxiliar2;
import Retos.Modelo.Reservacion;
import Retos.Servicio.ServicioReservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 57300
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class WebReservacion {
    @Autowired
    private ServicioReservacion servicio;
    @GetMapping("/all")
    public List<Reservacion> getReservation(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservacion> getReservacion(@PathVariable("id") int messageId) {
        return servicio.getReservation(messageId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion reservation) {
        return servicio.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion update(@RequestBody Reservacion reservation) {
        return servicio.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservation) {
        return servicio.deleteReservation(idReservation);
    }
    
    @GetMapping("/report-status")
    public Auxiliar2 getReservacionesStatus(){
        return servicio.getstatusReport();
    }
    
    @GetMapping("/report-clients")
    public List<Auxiliar> getTopClients(){
        return servicio.getTopCliente();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservacion> getDatesReport(@PathVariable("dateOne")String d1,@PathVariable("dateTwo") String d2){
        return servicio.getReservasPeriodo(d1, d2);
    }
}
