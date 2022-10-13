package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Admin;
import com.reto3Mintic.reto3Mintic.Repositorio.adminRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServicio {

    private adminRepositorio repositorio;

    public adminServicio(adminRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Admin>listaAdmin(){
        return (List<Admin>) repositorio.findAll(); //Método para consultar todos los administradores
    }

    public Admin buscarAdmin(int id){
        return repositorio.findById(id).get(); //Método para buscar administradores por Id
    }

   /* public Admin porEmail(String email){
        return repositorio.find
    }*/

}
