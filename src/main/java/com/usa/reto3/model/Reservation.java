package com.usa.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Lorena
 */
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    private String score; 

    /**
     * Este metodo nos permite obtener cualquier id de la tabla reservation
     * @return idReservation la id que identifica cada reservacion
     */
    public Integer getIdReservation() {
        return idReservation;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestra idReservation
     * @param idReservation la id que identifica cada reservacion
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    /**
     * Nos permite obtener el dato del startDate o fecha de inicio
     * de nuestra reservacion
     * @return la fecha de inicio de la reservacion 
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * Este metodo nos permite asignarle o modificar nuestra 
     * starDate (fecha de inicio) de nuestra tabla reservation
     * @param startDate 
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * Nos permite obtener el dato del devolutionDate o fecha de finalizacion
     * de nuestra reservacion
     * @return la fecha de finalizacion de la reservacion 
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    /**
     * Este metodo nos permite asignarle o modificar nuestra 
     * devolutionDate(fecha de inicio) de nuestra tabla reservation
     * @param devolutionDate  la fecha de finalizacion de la reservacion 
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    /**
     * Nos permite obtener el dato del estado de cada reservacion 
     * indicando si la reservacion fue creada
     * @return nos indica con un mensaje que la reservacion fue creada
     */
    public String getStatus() {
        return status;
    }
    /**
     * Este metodo nos permite asignarle o modificar nuestra 
     * el status de cada reservacion de nuestra tabla reservation
     * @param status nos indica con un mensaje que la reservacion fue creada
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * Nos permite obtener el arreglo creado apartir de la tabla room
     * @return arreglo con los objetos de la tabla room
     */
    public Room getRoom() {
        return room;
    }
    /**
     * Este metodo nos permite asignarle o modificar nuestro 
     * arreglo que proviene de la tabla room
     * @param room arreglo con los objetos de la tabla room
     */
    public void setRoom(Room room) {
        this.room = room;
    }
    /**
     * Nos permite obtener el arreglo creado apartir de la tabla client
     * @return arreglo con los objetos de la tabla client
     */
    public Client getClient() {
        return client;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestro
     * arreglo clients que contiene la informacion de la tabla client
     * @param client arreglo con los objetos de la tabla client
     */
    public void setClient(Client client) {
        this.client = client;
    }
    /**
     * Nos permite obtener el dato sobre la calificacion que se le da
     * a cada una de las habitaciones
     * @return calificacion de la habitacion 
     */
    public String getScore() {
        return score;
    }
    /**
     * Nos permite obtener el dato de la calificacion de cada reservacion 
     * @param score calificacion de la habitacion 
     */
    public void setScore(String score) {
        this.score = score;
    }   
}

