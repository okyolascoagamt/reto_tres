package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Client;
import com.reto3Mintic.reto3Mintic.Repositorio.clientRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clientServicio {

    private clientRepositorio repositorio;

    public clientServicio(clientRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public List<Client> listaClient(){
        return (List<Client>) repositorio.findAll();
    }
}
