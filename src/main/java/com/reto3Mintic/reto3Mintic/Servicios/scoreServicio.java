package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Score;
import com.reto3Mintic.reto3Mintic.Repositorio.scoreRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class scoreServicio {

    private scoreRepositorio repositorio;

    public scoreServicio(scoreRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Score> listaScore(){
        return (List<Score>) repositorio.findAll();
    }
}
