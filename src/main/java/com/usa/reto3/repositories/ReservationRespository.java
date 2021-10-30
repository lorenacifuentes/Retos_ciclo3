package com.usa.reto3.repositories;

import com.usa.reto3.model.CountClients;
import com.usa.reto3.model.Client;
import com.usa.reto3.model.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lorena
 */
@Repository
public class ReservationRespository{    
    @Autowired
    private ReservationCrudRepository reservationcrudrepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationcrudrepository.findAll();
    }  
    public Optional<Reservation> getReservation (int id){
        return reservationcrudrepository.findById(id);
    }
    public Reservation save (Reservation reservation){
        return reservationcrudrepository.save(reservation); 
    }
    public void delete (Reservation reservation){
        reservationcrudrepository.delete(reservation);
    }
    public List<Reservation> ReservacionStatusRepositorio (String status){
         return reservationcrudrepository.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return reservationcrudrepository.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }    
     public List<CountClients> getClientesRepositorio(){
         List<CountClients> res = new ArrayList<>();
         List<Object[]> report = reservationcrudrepository.countTotalReservationByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new CountClients((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }
}
