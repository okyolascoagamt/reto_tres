package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Repositorio.categoryRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryServicio {

    private categoryRepositorio repositorio;

    public categoryServicio(categoryRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public List<Category> listaCategory(){
        return (List<Category>) repositorio.findAll(); //Método para consultar todas las categorías
    }
}
