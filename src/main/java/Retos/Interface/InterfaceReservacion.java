/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Interface;

import Retos.Modelo.Reservacion;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 57300
 */
public interface InterfaceReservacion extends CrudRepository<Reservacion,Integer>{
    
    public List<Reservacion> findAllByStartDateAfterAndStartDateBefore (Date dateOne, Date dateTwo);
    
    public List<Reservacion> findAllByStatus (String status);
    
    @Query("select r.client, COUNT(r.client) from Reservacion AS r group by r.client order by COUNT(r.client) desc")
    public List<Object[]> countTotalReservacionByClient();
}
