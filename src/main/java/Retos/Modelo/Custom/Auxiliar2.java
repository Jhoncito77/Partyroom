/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Modelo.Custom;

/**
 * Esta clase es una auxiliar para poder contar la reservaciones completas y las canceladas para el reporte de status
 * @author 57300
 */
public class Auxiliar2 {
    private Integer completed;
    private Integer cancelled;

    public Auxiliar2(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    
    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }
    
    
}
