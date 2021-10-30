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
@Table(name="category")
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Room> rooms;

    /**
     * Este metodo nos permite obtener cualquier id de la tabla room
     * @return id la id que identifica cada categoria
     */
    public Integer getId() {
        return id;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestra id
     * @param id el id que nos identifica cada objeto de la tabla category
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Nos permite obtener el dato del nombre 
     * de nuestra tabla de category
     * @return nombre de la categoría
     */
    public String getName() {
        return name;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestro
     * campo name que contiene el nombre de la categoria
     * @param name nombre de la categoria
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Nos permite obtener el dato de la descripcion
     * de nuestra category asignada en nuestra tabla category
     * @return 
     */
    public String getDescription() {
        return description;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestro
     * campo description que contiene la descripcion de la habitación
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Nos permite obtener una lista creada apartir de la tabla room
     * @return lista con los objetos de la tabla room
     */
    public List<Room> getRooms() {
        return rooms;
    }
    /**
     * Este metodo nos permite asignarle un valor a nuestra
     * lista rooms que contiene la informacion de la tabla room
     * @param rooms lista con los objetos de la tabla room
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }   
}
