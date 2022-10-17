package com.reto3Mintic.reto3Mintic.Repositorio;

import com.reto3Mintic.reto3Mintic.Entidades.Admin;
import com.reto3Mintic.reto3Mintic.Entidades.Reservation;
import com.reto3Mintic.reto3Mintic.Entidades.Score;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.scoreCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class scoreRepositorio {

    @Autowired
    private scoreCrudRepositorio repositorio;

    public List<Score> listaScore(){
        return (List<Score>) repositorio.findAll();
    }

    public Optional<Score> buscarScore(int idScore){
        return repositorio.findById(idScore); //Método para buscar administradores por Id
    }

    public String agregarScore(Score score){
        if(buscarScore(score.getIdScore()).isPresent()){
            return "Reservation ya existe";
        }else{
            repositorio.save(score);
            return ("Reservation guardada");
        }

    }

    public String actualizarScore(Score score){
        if(buscarScore(score.getIdScore()).isPresent()){
            repositorio.save(score);
            return "Score modificada exitosamente";
        }else {
            return "Score a actualizar no se encontró";
        }
    }

    public void eliminarScoreAll(Score score){ //método para eliminar
        repositorio.delete(score);
    }

    public String eliminarScore(Integer idScore){
        if(buscarScore(idScore).isPresent()){
            repositorio.deleteById(idScore);
            return "Score eliminado";
        }else {
            return "No se encuentra el Score";
        }
    }

}
