package com.reto3Mintic.reto3Mintic.Repositorio;

import com.reto3Mintic.reto3Mintic.Entidades.Admin;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.adminCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class adminRepositorio {

    @Autowired
    private adminCrudRepositorio repositorio;

    public List<Admin> listaAdmin(){
        return (List<Admin>) repositorio.findAll();
    }


    public Optional<Admin> buscarAdmin(int id){
        return repositorio.findById(id); //Método para buscar administradores por Id
    }

    public String agregarAdmin(Admin admin){  //método para insertar
        if(buscarAdmin(admin.getIdAdmin()).isPresent()){
            return "Admin Ya existe";
        }else{
            repositorio.save(admin);
            return ("Admin guardado");
        }

    }
    public void eliminarAdminAll(Admin admin){ //método para eliminar
        repositorio.delete(admin);
    }

    public String eliminarAdmin(Integer idAmin){
        if(buscarAdmin(idAmin).isPresent()){
            repositorio.deleteById(idAmin);
            return "Admin eliminado";
        }else {
            return "No se encuentra el Admin";
        }
    }


}
