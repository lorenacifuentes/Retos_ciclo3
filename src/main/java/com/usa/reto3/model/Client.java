package com.usa.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lorena
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;
    
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Message>messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Reservation>reservations;
    
    /**
     * Este metodo nos permite obtener cualquier id de la tabla client
     * @return idClient la id que identifica cada cliente
     */
    public Integer getIdClient() {
        return idClient;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestra idClient
     * @param idClient la id que identifica cada mensaje
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
    /**
     * Nos permite obtener el dato del email de nuestra tabla client
     * @return email del cliente
     */
    public String getEmail() {
        return email;
    }
    /**     
     * Este metodo nos permite asignarle o modificar
     * nuestro email password de nuestra tabla client 
     * @param email parametro email de la tabla cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Nos permite obtener el dato del password de nuestra tabla client
     * @return contraseña del cliente
     */
    public String getPassword() {
        return password;
    }
    /**
     * Este metodo nos permite asignarle o modificar
     * nuestro valor password de nuestra tabla client 
     * @param password parametro password de la tabla cliente
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Nos permite obtener el dato del name de nuestra tabla client
     * @return nombre del cliente
     */
    public String getName() {
        return name;
    }
    /**
     * Este metodo nos permite asignarle o modificar
     * nuestro valor name de nuestra tabla client
     * @param name parametro name de la tabla cliente
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Nos permite obtener el dato del age de nuestra tabla client
     * @return edad del cliente
     */
    public Integer getAge() {
        return age;
    }
    /**
     * Este metodo nos permite asignarle o modificar
     * nuestro valor age de nuestra tabla client
     * @param age parametro age de la tabla cliente
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * Nos permite obtener una lista creada apartir de la tabla message
     * @return lista con los objetos de la tabla message
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     * Este metodo nos permite establecer un valor a nuestra
     * lista menssages que contiene la informacion de la tabla message
     * @param messages nombre del parametro donde se encuentra la lista
     * con los datos de reservation
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     * Nos permite obtener una lista creada apartir de la tabla reservation
     * @return lista con los objetos de la tabla reservation
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     * Este metodo nos permite establecer un valor a nuestra
     * lista reservations que contiene la informacion de la tabla reservation
     * @param reservations nombre del parametro donde se encuentra la lista
     * con los datos de reservation
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }   
}
