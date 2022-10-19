package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Client;
import com.reto3Mintic.reto3Mintic.Entidades.DTOs.CountClient;
import com.reto3Mintic.reto3Mintic.Entidades.DTOs.CountStatus;
import com.reto3Mintic.reto3Mintic.Entidades.Reservation;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.reservationCrudRepositorio;
import com.reto3Mintic.reto3Mintic.Repositorio.reservationRepositorio;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class reservationServicio {

    private reservationCrudRepositorio repositorio;

    public reservationServicio(reservationCrudRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Reservation> listaReservation(){
        return (List<Reservation>) repositorio.findAll();
    }


    public Optional<Reservation> buscarReservation(int idReservation){
        return repositorio.findById(idReservation); //Método para buscar administradores por Id
    }

    public String agregarReservation(Reservation reservation){
        if(buscarReservation(reservation.getIdReservation()).isPresent()){
            return "Reservation ya existe";
        }else{
            repositorio.save(reservation);
            return ("Reservation guardada");
        }

    }

    public String actualizarReservation(Reservation reservation){
        if(buscarReservation(reservation.getIdReservation()).isPresent()){
            repositorio.save(reservation);
            return "Reservation modificada exitosamente";
        }else {
            return "Reservation a actualizar no se encontró";
        }
    }
    public void eliminarReservationAll(Reservation reservation){ //método para eliminar
        repositorio.delete(reservation);
    }

    public String eliminarReservation(Integer idReservation){
        if(buscarReservation(idReservation).isPresent()){
            repositorio.deleteById(idReservation);
            return "Reservation eliminado";
        }else {
            return "No se encuentra el Reservation";
        }
    }

    //Reto 5

    public List<CountClient> getTopClients(){
        List<CountClient> respuesta = new ArrayList<>();

        List<Object[]> reporte = repositorio.countTotalReservationsByCLients();

        for (int i=0; i<reporte.size(); i++){
            respuesta.add(new CountClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0] ));
        }
        return respuesta;
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser= new SimpleDateFormat("yyyy-MM-dd"); //2022-01-21
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(dateA);
            b= parser.parse(dateB);
        }catch (ParseException excepcion){
            excepcion.printStackTrace();
        }
        if(a.before(b)){
            return repositorio.findAllByStartDateAfterAndDevolutionDateBefore(a,b);
        }else {
            return new ArrayList<>();
        }
    }

    public CountStatus getReservationsStatus(){
        List<Reservation> completed = repositorio.findAllByStatus("completed");
        List<Reservation> cancelled = repositorio.findAllByStatus("cancelled");
        return new CountStatus((long) completed.size(), (long) cancelled.size());
    }

}
