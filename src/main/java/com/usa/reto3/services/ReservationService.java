package com.usa.reto3.services;

import com.usa.reto3.model.CountClients;
import com.usa.reto3.model.Reservation;
import com.usa.reto3.model.StatusReservation;
import com.usa.reto3.repositories.ReservationRespository;
import java.text.ParseException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lorena
 */
@Service
public class ReservationService {
    @Autowired
    /**
     * Repositorio de Reservaciones
     */
    private ReservationRespository reservationRespository;
    /**
     * Obtener todo lo guardado en la tabla de Reservation
     * @return lo elementos que contiene la tabla de reservaciones
     */
    public List<Reservation> getAll(){
        return reservationRespository.getAll();
    }
    /**
     * Obtenemos un elemento de la tabla Reservation por medio de su id
     * @param id es con la que identificaremos a un elemento en especifico
     * @return el objeto con el id
     */
    public Optional<Reservation> getReservation(int id){
        return reservationRespository.getReservation(id);
    }
    /**
     * Nos permite guardar un elemento en la tabla de Reservaciones
     * @param reservation elemento de la tabla resevation
     * @return Nos retorna la reservacion que creamos
     */
    public Reservation saveReservation (Reservation reservation){
        if (reservation.getIdReservation()== null){
            return reservationRespository.save(reservation);
        }else{
            Optional<Reservation> ReservationNew= reservationRespository.getReservation(reservation.getIdReservation());
            if(!ReservationNew.isPresent()){
                return reservationRespository.save(reservation);
            } else{
                return reservation;
            }
        }
    }    
    /**
     * Con este metodo podemos actualizar nuestra reservación mediante su 
     * id y despues salvar los cambios correspondientes
     * @param reservation nos referimos a la reservación que creamos
     * @return la reservacion actualizada con los nuevos datos que ingresemos
     */
    public Reservation updateReservation (Reservation reservation){
    if(reservation.getIdReservation()!= null){
        Optional<Reservation> ReservationActu= reservationRespository.getReservation(reservation.getIdReservation());
        if(ReservationActu.isPresent()){
            if(reservation.getStartDate()!= null){
                ReservationActu.get().setStartDate(reservation.getStartDate());
            }
            if(reservation.getDevolutionDate()!=null){
                ReservationActu.get().setDevolutionDate(reservation.getDevolutionDate());
            }
            if(reservation.getStatus()!=null){
            ReservationActu.get().setStatus(reservation.getStatus());
            }
            reservationRespository.save (ReservationActu.get());
            return ReservationActu.get();
        }else{
            return reservation;
            }
    }else{
        return reservation;
        }
    }
    /**
     * Nos permite eliminar un elemento de la tabla reservation mediante su id
     * @param id el id de uno de los elementos que nos permita identificalo para 
     * poder eliminarlo unicamente a ese elemento
     * @return Nos indica si el objeto fue eliminado o no
     */
    public boolean deleteReservation(int id){
        Optional<Reservation> ReservationBorr= getReservation(id);
        if(ReservationBorr.isPresent()){
           reservationRespository.delete(ReservationBorr.get()); 
           return true;
        }
        return false;
    } 
    public StatusReservation reporteStatusServicio (){
        List<Reservation>completed= reservationRespository.ReservacionStatusRepositorio("completed");
        List<Reservation>cancelled= reservationRespository.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservation(completed.size(), cancelled.size() );
    }
    
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRespository.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }    
    public List<CountClients> reporteClientesServicio(){
            return reservationRespository.getClientesRepositorio();
        }
}
