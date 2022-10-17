package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Message;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.messageCrudRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class messageServicio {
    private messageCrudRepositorio repositorio;

    public messageServicio(messageCrudRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public List<Message> listaMessage(){
        return (List<Message>) repositorio.findAll();
    }

    public Optional<Message> buscarMessage(int idMessage){
        return repositorio.findById(idMessage); //Método para buscar administradores por Id
    }

    public String agregarMessage(Message message){
        if(buscarMessage(message.getIdMessage()).isPresent()){
            return "Message ya existe";
        }else{
            repositorio.save(message);
            return ("Message guardado");
        }

    }

    public String actualizarMessage(Message message){
        if(buscarMessage(message.getIdMessage()).isPresent()){
            repositorio.save(message);
            return "Message modificado exitosamente";
        }else {
            return "Message a actualizar no se encontró";
        }
    }

    public void eliminarMessageAll(Message message){ //método para eliminar
        repositorio.delete(message);
    }


    public String eliminarMessage(Integer idMessage){
        if(buscarMessage(idMessage).isPresent()){
            repositorio.deleteById(idMessage);
            return "Message eliminado";
        }else {
            return "No se encuentra el Message";
        }
    }

}
