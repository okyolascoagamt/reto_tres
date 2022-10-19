package com.reto3Mintic.reto3Mintic.Controlador;


import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Entidades.DTOs.CountClient;
import com.reto3Mintic.reto3Mintic.Entidades.DTOs.CountStatus;
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

    @GetMapping("/api/Reservation/report-clients")
    public List<CountClient>getReportTopClients(){
        return servicio.getTopClients();
    }

    @GetMapping("/api/Reservation/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation>getReportReservationsDate(@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
        return servicio.getReservationPeriod(dateOne, dateTwo);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return getReservationsByStatus(status);
    }

    @GetMapping("/api/Reservation/report-status")
    public CountStatus getReportStatusReservations(){
        return servicio.getReservationsStatus();
    }
}
