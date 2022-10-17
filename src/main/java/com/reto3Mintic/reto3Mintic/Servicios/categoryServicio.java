package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Category;
import com.reto3Mintic.reto3Mintic.Repositorio.categoryRepositorio;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.categoryCrudRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoryServicio {

    private categoryCrudRepositorio repositorio;

    public categoryServicio(categoryCrudRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public List<Category> listaCategory(){
        return (List<Category>) repositorio.findAll(); //Método para consultar todas las categorías
    }

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

    public String actualizarCategory(Category category){
        if(buscarCategory(category.getId()).isPresent()){
            repositorio.save(category);
            return "Category modificada exitosamente";
        }else {
            return "La categoría a actualizar no se encontró";
        }
    }
    public void eliminarCategory(Category category){ //método para eliminar
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
