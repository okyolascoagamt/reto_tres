package com.reto3Mintic.reto3Mintic.Repositorio;

import com.reto3Mintic.reto3Mintic.Entidades.Admin;
import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.categoryCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class categoryRepositorio {

    @Autowired
    private categoryCrudRepositorio repositorio;

    public Optional<Category> buscarCategory(int id){
        return repositorio.findById(id); //Método para buscar administradores por Id
    }

    public String agregarCategory(Category category){
        if(buscarCategory(category.getId()).isPresent()){
            return "Category Ya existe";
        }else{
            repositorio.save(category);
            return ("Category guardado");
        }

    }

    public void eliminarCategoryAll(Category category){ //método para eliminar
        repositorio.delete(category);
    }

    public String eliminarCategory(Integer id){
        if(buscarCategory(id).isPresent()){
            repositorio.deleteById(id);
            return "Category eliminada";
        }else {
            return "No se encuentra la Category";
        }
    }
}
