package com.reto3Mintic.reto3Mintic.Controlador;

import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Entidades.Client;
import com.reto3Mintic.reto3Mintic.Entidades.Library;
import com.reto3Mintic.reto3Mintic.Entidades.Message;
import com.reto3Mintic.reto3Mintic.Servicios.messageServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class messageControlador {

    @Autowired
    private messageServicio servicio;

    public messageControlador(messageServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/api/Message/all")
    public List<Message> listar(){
        return servicio.listaMessage();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/Message/save")
    public String agregarMessage(@RequestBody Message message){
        return servicio.agregarMessage(message);
    }

    @PutMapping("/api/Message/update")
    public String actualizarMessage(@RequestBody Message message) {
        return servicio.actualizarMessage(message);
    }

    @DeleteMapping("/api/Message/delete/{idMessage}")
    public String eliminarMessage(@PathVariable("idMessage") Integer idMessage){
        return servicio.eliminarMessage(idMessage);
    }


}
