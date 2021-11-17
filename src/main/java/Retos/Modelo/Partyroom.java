/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Esta clase crea la tabla Partyroom y establece los atributos necesarios
 * para los servicios REST
 * @author Jhon Moreno
 * @version 1.0
 */
@Entity
@Table(name="partyroom")
public class Partyroom implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    private String description;
    
    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties({"partyrooms"})
    private Categoria category;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy ="partyroom")
    @JsonIgnoreProperties({"partyroom","client"})
    private List<Mensaje> messages;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy ="partyroom")
    @JsonIgnoreProperties({"partyroom","message"})
    private List<Reservacion> reservations;

    /**
     * Metodo Get para consultar el id de un Partyroom
     * @return El id del partyroom
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo Set para modificar el id de un partyroom
     * @param id El id del partyroom
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo get para consultar el dueño del partyroom
     * @return El propietario del partyroom
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Metodo set para modificar el dueño o propietario del partyroom
     * @param owner El propietario del partyroom
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Metodo get para consultar la capacidad de un partyroom
     * @return La capacidad del partyroom
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Metodo set para modificar la capacidad de un partyroom
     * @param capacity La capacidad de un partyroom
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * Metodo get para consultar el nombre de un partyroom
     * @return El nombre del partyrrom
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo set para modificar el nombre de un partyroom
     * @param name El nombre de un partyroom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo get para consultar la descripcon de un partyroom
     * @return La descripcion del partyroom
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metodo set para modificar la descripcion de un partyroom
     * @param description La descripcion de un partyroom
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo get para consultar la categoria de un partyroom
     * @return La categoria de un partyroom
     */
    public Categoria getCategory() {
        return category;
    }

    /**
     * Metodo set para modificar la categoria de un partyroom
     * @param category La categoria de un partyroom
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /**
     * Metodo get para consultar los mensajes de un partyroom
     * @return Los mensajes de un partyroom
     */
    public List<Mensaje> getMessages() {
        return messages;
    }

    /**
     * Metodo set para modificar los mensjaes de un partyroom
     * @param messages Los mensajes de un partyroom
     */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    /**
     * Metodo get para consultar las reservaciones de un partyroom
     * @return Las reservaciones de un partyroom
     */
    public List<Reservacion> getReservations() {
        return reservations;
    }

    /**
     * Metodo set para modificar las reservaciones de un partyroom
     * @param reservations Las reservacionesd de un partyroom
     */
    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }
    
    
}
