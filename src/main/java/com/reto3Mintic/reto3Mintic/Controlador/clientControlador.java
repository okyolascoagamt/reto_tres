package com.reto3Mintic.reto3Mintic.Controlador;

import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Entidades.Client;
import com.reto3Mintic.reto3Mintic.Servicios.clientServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class clientControlador {

    @Autowired
    private clientServicio servicio;

    public clientControlador(clientServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/api/Client/all")
    public List<Client> listar(){
        return servicio.listaClient();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/Client/save")
    public String agregarClient(@RequestBody Client client){
        return servicio.agregarClient(client);
    }

    @PutMapping("/api/Client/update")
    public String actualizarClient(@RequestBody Client client) {

        return servicio.actualizarClient(client);
    }

    @DeleteMapping("/api/Client/{id}")
    public String eliminarClient(@PathVariable("id") Integer idCLient){
        return servicio.eliminarClient(idCLient);
    }


}
