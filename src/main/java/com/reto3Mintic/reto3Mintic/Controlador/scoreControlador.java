package com.reto3Mintic.reto3Mintic.Controlador;


import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Entidades.Score;
import com.reto3Mintic.reto3Mintic.Servicios.scoreServicio;
import org.springframework.beans.factory.annotation.Autowired;
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


    @DeleteMapping("/api/Score/delete/{idScore}")
    public String eliminarScore(@PathVariable("idScore") Integer idScore){
        return servicio.eliminarScore(idScore);
    }
}
