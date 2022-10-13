package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Message;
import com.reto3Mintic.reto3Mintic.Repositorio.messageRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class messageServicio {
    private messageRepositorio repositorio;

    public messageServicio(messageRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public List<Message> listaMessage(){
        return (List<Message>) repositorio.findAll();
    }
}
