/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Modelo.Custom;

import Retos.Modelo.Cliente;
import Retos.Modelo.Reservacion;

/**
 * Esta clase sirve unicamente para poder aplicar el metodo para el top clientes del repositorioReservacion
 * @author 57300
 */
public class Auxiliar {
    
    private Long total;
    private Cliente client;

    public Auxiliar(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getclient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
    
    
}
