package com.usa.reto3.model;

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
 *
 * @author Lorena
 */
@Entity
@Table(name = "room")
public class Room implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String hotel;
    private Integer stars;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("rooms")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Reservation> reservations;   

    /**
     * Este metodo nos permite obtener cualquier id de la tabla room
     * @return id id que nos identifica cada objeto de la tabla room
     */
    public Integer getId() {
        return id;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestra id
     * @param id el id que nos identifica cada objeto de la tabla room
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Nos permite obtener el dato del nombre 
     * de la habitacion alamacenada dentro de la tabla room
     * @return nombre de la habitación
     */
    public String getName() {
        return name;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestro
     * campo name que contiene el número de la habitación
     * @param name nombre de la habitación
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Nos permite obtener el dato del nombre 
     * del hotel que esta almacenado en la tabla room 
     * @return hotel
     */
    public String getHotel() {
        return hotel;
    }
    /**     
     * Este metodo nos permite asignarle un valor a nuestro
     * campo hotel que contiene el nombre del hotel
     * @param hotel nombre del hotel
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    /**
     * Nos permite obtener el dato de las estrellas que se le dieron
     * al hotel que se encuentra alamacenado dentro de la tabla room 
     * @return stars
     */
    public Integer getStars() {
        return stars;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestro
     * campo stars que contiene el numero de estrellas que tiene
     * el hotel
     * @param stars 
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }
    /**
     * Nos permite obtener el dato de la descripcion que tiene una
     * habitacion que se encuentra alamacenado dentro de la tabla room 
     * @return descripcion
     */
    public String getDescription() {
        return description;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestro
     * campo description que contiene una breve descripcion de 
     * la habitación
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Nos permite obtener el arreglo de category que es asignado 
     * a cada habitacion de la tabla room 
     * @return category 
     */
    public Category getCategory() {
        return category;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestro
     * arreglo category que contiene la categoria de la habitacion
     * @param category 
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     *Nos permite obtener el arreglo de messages que es asignado 
     * a cada habitacion de la tabla room 
     * @return 
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestro
     * arreglo de messages que contiene cada habitacion
     * @param messages 
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestro
     * lista de reservation que se le asigna a cada habitacion
     * @return reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     * Nos permite obtener una lista de reservation que es asignado 
     * a cada habitacion de la tabla room cuando se realiza una 
     * reservación
     * @param reservations 
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }   
}
