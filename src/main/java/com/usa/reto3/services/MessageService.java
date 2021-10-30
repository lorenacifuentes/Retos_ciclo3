package com.usa.reto3.services;

import com.usa.reto3.model.Message;
import com.usa.reto3.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lorena
 */
@Service
public class MessageService {
    @Autowired
    
    private MessageRepository messageRespository;
    
    public List<Message> getAll(){
        return messageRespository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRespository.getMessage(id);
    }
    public Message saveMessage(Message message){
        if (message.getIdMessage()== null){
            return messageRespository.save(message);
        }else{
            Optional<Message> MessageNew= messageRespository.getMessage(message.getIdMessage());
            if(!MessageNew.isPresent()){
                return messageRespository.save(message);
            } else{
                return message;
            }
        }
    }    
    public Message updateMessage (Message message){
    if(message.getIdMessage()!= null){
        Optional<Message> MessageActu= messageRespository.getMessage(message.getIdMessage());
        if(MessageActu.isPresent()){
            if(message.getMessageText()!= null){
                MessageActu.get().setMessageText(message.getMessageText());
            }
            messageRespository.save (MessageActu.get());
            return MessageActu.get();
        }else{
            return message;
            }
    }else{
        return message;
        }
    }   
    public boolean deleteMessage(int id){
        Optional<Message> MessageBorr= getMessage(id);
        if(MessageBorr.isPresent()){
           messageRespository.delete(MessageBorr.get()); 
           return true;
        }
        return false;
    } 
}
