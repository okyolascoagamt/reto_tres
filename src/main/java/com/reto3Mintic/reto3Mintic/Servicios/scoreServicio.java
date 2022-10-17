package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Score;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.scoreCrudRepositorio;
import com.reto3Mintic.reto3Mintic.Repositorio.scoreRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class scoreServicio {

    private scoreCrudRepositorio repositorio;

    public scoreServicio(scoreCrudRepositorio repositorio) {
        this.repositorio = repositorio;
    }

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

   /* public void eliminarScoreAll(Score score){ //método para eliminar
        repositorio.delete(score);
    }*/

    public String eliminarScore(Integer idScore){
        if(buscarScore(idScore).isPresent()){
            repositorio.deleteById(idScore);
            return "Score eliminado";
        }else {
            return "No se encuentra el Score";
        }
    }
}
