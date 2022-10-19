package com.reto3Mintic.reto3Mintic.Repositorio.crudRepositorio;

import com.reto3Mintic.reto3Mintic.Entidades.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface reservationCrudRepositorio extends CrudRepository<Reservation, Integer> {
   /*
    @Query("SELECT l.library, COUNT(l.library) from Reservation AS l GROUP BY l.library ORDER BY COUNT(l.library) DESC")
    public List<Object[]> countTotalReservationByLibrary();*/

    // [client, ttoal]//
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByCLients();

    //SELECT * FROM Reservation WHERE startDate AFTER dateOne AND devolutionDate BEFORE dateTwo;
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);

    //SELECT * FROM Reservation WHERE status = 'cancelled'
    //SELECT * FROM Reservation WHERE status = 'completed'
    public List<Reservation>findAllByStatus(String status);



}
