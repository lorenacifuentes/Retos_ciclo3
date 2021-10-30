package com.usa.reto3.services;

import com.usa.reto3.model.Room;
import com.usa.reto3.repositories.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author Lorena
 */
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRespository;
    
    public List<Room> getAll(){
        return roomRespository.getAll();
    }
    public Optional<Room> getRoom(int id){
        return roomRespository.getRoom(id);
    }
    public Room saveRoom (Room room){
        if (room.getId()== null){
            return roomRespository.save(room);
        }else{
            Optional<Room> RoomNew= roomRespository.getRoom(room.getId());
            if(!RoomNew.isPresent()){
                return roomRespository.save(room);
            } else{
                return room;
            }
        }
    }    
    public Room updateRoom (Room room){
    if(room.getId() != null){
        Optional<Room> RoomActu= roomRespository.getRoom(room.getId());
        if(RoomActu.isPresent()){
            if(room.getName()!= null){
                RoomActu.get().setName(room.getName());
            }
            if(room.getHotel() !=null){
                RoomActu.get().setHotel(room.getHotel());               
            }
            if(room.getStars() !=null){
                RoomActu.get().setStars(room.getStars());
            }
            if(room.getDescription() !=null){
                RoomActu.get().setDescription(room.getDescription());
            }
            roomRespository.save (RoomActu.get());
            return RoomActu.get();
        }else{
            return room;
            }
    }else{
        return room;
        }
    }
    
    public boolean deleteCategory (int id){
        Optional<Room> RoomBorr= getRoom(id);
        if(RoomBorr.isPresent()){
           roomRespository.delete(RoomBorr.get()); 
           return true;
        }
        return false;
    } 
}

