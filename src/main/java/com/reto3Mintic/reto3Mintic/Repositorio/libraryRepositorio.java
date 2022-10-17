package com.reto3Mintic.reto3Mintic.Repositorio;

import com.reto3Mintic.reto3Mintic.Entidades.Admin;
import com.reto3Mintic.reto3Mintic.Entidades.Library;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.libraryCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class libraryRepositorio {

    @Autowired
    private libraryCrudRepositorio repositorio;

    public List<Library> listaLibrary(){

        return (List<Library>) repositorio.findAll();
    }

    public Optional<Library> buscarLibrary(int id){
        return repositorio.findById(id); //Método para buscar administradores por Id
    }

    public String agregarLibrary(Library library){
        if(buscarLibrary(library.getId()).isPresent()){
            return "Library Ya existe";
        }else{
            repositorio.save(library);
            return ("Library guardado");
        }

    }

    public void eliminarLibraryAll(Library library){ //método para eliminar
        repositorio.delete(library);
    }

    public String eliminarLibrary(Integer id){
        if(buscarLibrary(id).isPresent()){
            repositorio.deleteById(id);
            return "Library eliminado";
        }else {
            return "No se encuentra el Library";
        }
    }
}
