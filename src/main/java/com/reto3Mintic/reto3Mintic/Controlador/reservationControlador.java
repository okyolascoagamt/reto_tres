package com.reto3Mintic.reto3Mintic.Controlador;


import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Entidades.Message;
import com.reto3Mintic.reto3Mintic.Entidades.Reservation;
import com.reto3Mintic.reto3Mintic.Servicios.reservationServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class reservationControlador {

    @Autowired
    private reservationServicio servicio;

    public reservationControlador(reservationServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/api/Reservation/all")
    public List<Reservation> listar(){
        return servicio.listaReservation();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/Reservation/save")
    public String agregarReservation(@RequestBody Reservation reservation){
        return servicio.agregarReservation(reservation);
    }

    @PutMapping("/api/Reservation/update")
    public String actualizarReservation(@RequestBody Reservation reservation) {
        return servicio.actualizarReservation(reservation);
    }

    @DeleteMapping("/api/Reservation/{id}")
    public String eliminarReservation(@PathVariable("id") Integer idReservation){
        return servicio.eliminarReservation(idReservation);
    }

}
