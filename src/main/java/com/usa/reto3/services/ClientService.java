package com.usa.reto3.services;

import com.usa.reto3.model.Client;
import com.usa.reto3.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lorena
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRespository;
    
    public List<Client> getAll(){
        return clientRespository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRespository.getClient(id);
    }
    public Client saveClient(Client client){
        if (client.getIdClient()== null){
            return clientRespository.save(client);
        }else{
            Optional<Client> ClientNew= clientRespository.getClient(client.getIdClient());
            if(!ClientNew.isPresent()){
                return clientRespository.save(client);
            } else{
                return client;
            }
        }
    }    
    public Client updateClient (Client client){
    if(client.getIdClient() != null){
        Optional<Client> ClientActu= clientRespository.getClient(client.getIdClient());
        if(ClientActu.isPresent()){
            if(client.getEmail()!= null){
                ClientActu.get().setEmail(client.getEmail());
            }
            if(client.getPassword()!=null){
                ClientActu.get().setPassword(client.getPassword());
            }
            if(client.getName()!=null){
                ClientActu.get().setName(client.getName());
            }
            if(client.getAge()!=null){
                ClientActu.get().setAge(client.getAge());
            }
            clientRespository.save (ClientActu.get());
            return ClientActu.get();
        }else{
            return client;
            }
    }else{
        return client;
        }
    }   
    public boolean deleteClient (int id){
        Optional<Client> ClientBorr= getClient(id);
        if(ClientBorr.isPresent()){
           clientRespository.delete(ClientBorr.get()); 
           return true;
        }
        return false;
    } 
}
