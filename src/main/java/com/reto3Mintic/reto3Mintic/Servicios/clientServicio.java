package com.reto3Mintic.reto3Mintic.Servicios;

import com.reto3Mintic.reto3Mintic.Entidades.Client;
import com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio.clientCrudRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clientServicio {

    private clientCrudRepositorio repositorio;

    public clientServicio(clientCrudRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public List<Client> listaClient(){
        return (List<Client>) repositorio.findAll();
    }


    public Optional<Client> buscarClient(int idClient){
        return repositorio.findById(idClient); //Método para buscar administradores por Id
    }

    public String agregarClient(Client client){
        if(buscarClient(client.getIdClient()).isPresent()){
            return "Client ya existe";
        }else{
            repositorio.save(client);
            return ("Client guardado");
        }

    }

    public String actualizarClient(Client client){
        if(buscarClient(client.getIdClient()).isPresent()){
            repositorio.save(client);
            return "Cliente modificado exitosamente";
        }else {
            return "El cliente a actualizar no se encontró";
        }
    }

    public void eliminarClientAll(Client client){ //método para eliminar
        repositorio.delete(client);
    }

    public String eliminarClient(Integer idClient){
        if(buscarClient(idClient).isPresent()){
            repositorio.deleteById(idClient);
            return "Cliente eliminado";
        }else {
            return "No se encuentra el cliente";
        }
    }
}
