package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Reservation;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.reservationCrudRepositorio;
import com.reto3Mintic.reto3Mintic.Repositorio.reservationRepositorio;
import org.springframework.stereotype.Service;

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
}
