package com.usa.reto3.repositories;

import com.usa.reto3.model.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Lorena
 */
@Repository
public class RoomRepository{
    
    @Autowired
    private RoomCrudRepository roomcrudrepository;
    
    public List<Room> getAll(){
        return (List<Room>) roomcrudrepository.findAll();
    }
    
    public Optional<Room> getRoom (int id){
        return roomcrudrepository.findById(id);
    }
    public Room save (Room room){
        return roomcrudrepository.save(room); 
    }
    public void delete (Room room){
        roomcrudrepository.delete(room);
    }
}
