package com.reto3Mintic.reto3Mintic.Repositorio;


import com.reto3Mintic.reto3Mintic.Entidades.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepositorio extends CrudRepository<Category, Integer> {
}
