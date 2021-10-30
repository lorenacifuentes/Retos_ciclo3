package com.usa.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Room room;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Client client;

    /**
     * Este metodo nos permite obtener cualquier id de la tabla message
     * @return idMessage la id que identifica cada mensaje
     */
    public Integer getIdMessage() {
        return idMessage;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestra idMessage
     * @param idMessage la id que identifica cada mensaje
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    /**
     * Nos permite obtener el dato del messageText
     * de nuestra tabla message
     * @return messageText
     */
    public String getMessageText() {
        return messageText;
    }
    /**
     * Este metodo nos permite asignarle o modificar
     * nuestro valor MessageText de nuestra tabla message
     * @param messageText 
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    /**
     * Nos permite obtener el arreglo creado apartir de la tabla room
     * @return arreglo con los objetos de la tabla room
     */
    public Room getRoom() {
        return room;
    }
    /**
     * Este metodo nos permite asignarle o modificar
     * un valor a nuestro arreglo de room 
     * @param room arreglo con los objetos de la tabla client
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
}
