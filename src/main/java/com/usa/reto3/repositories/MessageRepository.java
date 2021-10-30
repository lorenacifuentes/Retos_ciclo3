package com.usa.reto3.repositories;

import com.usa.reto3.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lorena
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messagecrudrepository;
    
    public List<Message> getAll(){
        return (List<Message>) messagecrudrepository.findAll();
    }
    
    public Optional<Message> getMessage (int id){
        return messagecrudrepository.findById(id);
    }
    public Message save (Message message){
        return messagecrudrepository.save(message); 
    }
    public void delete (Message message){
        messagecrudrepository.delete(message);
    }
}

