package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Library;
import com.reto3Mintic.reto3Mintic.Repositorio.libraryRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class libraryServicio {

    private libraryRepositorio repositorio;

    public libraryServicio(libraryRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public List<Library> listaLibrary(){
        return (List<Library>) repositorio.findAll();
    }
}
