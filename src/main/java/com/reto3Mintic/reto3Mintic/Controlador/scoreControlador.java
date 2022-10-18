package com.reto3Mintic.reto3Mintic.Controlador;


import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Entidades.Reservation;
import com.reto3Mintic.reto3Mintic.Entidades.Score;
import com.reto3Mintic.reto3Mintic.Servicios.scoreServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class scoreControlador {

    @Autowired
    private scoreServicio servicio;

    public scoreControlador(scoreServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/api/Score/all")
    public List<Score> listar(){
        return servicio.listaScore();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/Score/save")
    public String agregarScore(@RequestBody Score score){
        return servicio.agregarScore(score);
    }
    @PutMapping("/api/Score/update")
    public String actualizarScore(@RequestBody Score score) {
        return servicio.actualizarScore(score);
    }

    @DeleteMapping("/api/Score/{id}")
    public String eliminarScore(@PathVariable("id") Integer idScore){
        return servicio.eliminarScore(idScore);
    }
}
