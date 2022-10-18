package com.reto3Mintic.reto3Mintic.Controlador;

import com.reto3Mintic.reto3Mintic.Entidades.Admin;
import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Servicios.categoryServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class categoryControlador {

    @Autowired
    private categoryServicio servicio;

    public categoryControlador(categoryServicio servicio) {
        this.servicio = servicio;
    }


    @GetMapping("/api/Category/all")
    public List<Category> listar() {
        return servicio.listaCategory();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/Category/save")
    public String agregarCategory(@RequestBody Category category) {
        return servicio.agregarCategory(category);
    }

    @PutMapping("/api/Category/update")
    public String actualizarCategory(@RequestBody Category category) {
        return servicio.actualizarCategory(category);
    }

    @DeleteMapping("/api/Category/{id}")
    public String eliminarCategory(@PathVariable("id") Integer id){
        return servicio.eliminarCategory(id);
    }
}