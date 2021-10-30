package com.usa.reto3.repositories;

import com.usa.reto3.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lorena
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientcrudrepository;
    
    public List<Client> getAll(){
        return (List<Client>) clientcrudrepository.findAll();
    }   
    public Optional<Client> getClient (int id){
        return clientcrudrepository.findById(id);
    }
    public Client save (Client client){
        return clientcrudrepository.save(client); 
    }
    public void delete (Client client){
        clientcrudrepository.delete(client);
    }
}
