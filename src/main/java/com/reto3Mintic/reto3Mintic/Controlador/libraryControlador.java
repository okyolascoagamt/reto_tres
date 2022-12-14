package com.reto3Mintic.reto3Mintic.Controlador;

import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Entidades.Client;
import com.reto3Mintic.reto3Mintic.Entidades.Library;
import com.reto3Mintic.reto3Mintic.Servicios.libraryServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class libraryControlador {

    @Autowired
    private libraryServicio servicio;

    public libraryControlador(libraryServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/api/Lib/all")
    public List<Library> listar(){
        return servicio.listaLibrary();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/Lib/save")
    public String agregarLibrary(@RequestBody Library library){
        return servicio.agregarLibrary(library);
    }

    @PutMapping("/api/Library/update")
    public String actualizarLibrary(@RequestBody Library library) {
        return servicio.actualizarLibrary(library);
    }

    @DeleteMapping("/api/Library/{id}")
    public String eliminarLibrary(@PathVariable("id") Integer id){
        return servicio.eliminarLibrary(id);
    }

}
