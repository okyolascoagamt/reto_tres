package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Reservation;
import com.reto3Mintic.reto3Mintic.Repositorio.reservationRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reservationServicio {

    private reservationRepositorio repositorio;

    public reservationServicio(reservationRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Reservation> listaResertation(){
        return (List<Reservation>) repositorio.findAll();
    }
}
