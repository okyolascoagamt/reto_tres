package com.reto3Mintic.reto3Mintic.Controlador;


import com.reto3Mintic.reto3Mintic.Entidades.Admin;
import com.reto3Mintic.reto3Mintic.Servicios.adminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class adminControlador {

    @Autowired
    private adminServicio servicio;

    public adminControlador(adminServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/api/Admin/all")
    public List<Admin> listar(){
        return servicio.listaAdmin();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/Admin/save")
    public String agregarAdmin(@RequestBody Admin admin){
        return servicio.agregarAdmin(admin);
    }

    @PutMapping("/api/Admin/update")
    public String actualizarAdmin(@RequestBody Admin admin){
        return servicio.actualizarAdmin(admin);
    }

    @DeleteMapping("/api/Admin/delete/all")
    public void eliminarAdminAll(Admin admin){
        servicio.eliminarAdminAll(admin);
    }

    @DeleteMapping("/api/Admin/{id}")
    public String eliminarAdmin(@PathVariable("idAdmin") Integer idAmin){
        return servicio.eliminarAdmin(idAmin);
    }

}
