
package com.reto3Mintic.reto3Mintic.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation", unique = true, nullable = false)
    private int idReservation;

    //@Temporal(TemporalType.DATE)
    @Column(name = "startDate", nullable = false )
    private Date startDate;

    @Column(name = "devolutionDate", nullable = true)
    private Date devolutionDate;

    @Column(name = "status", nullable = true, length = 45)
    private String status ="Created";

    @ManyToOne
    @JoinColumn(name = "libId")
    @JsonIgnoreProperties("reservations")
    private Library lib;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;


    @ManyToOne
    @JoinColumn(name = "scoreId")
    @JsonIgnoreProperties
    private Score score;

    /*
    @OneToOne
    @JsonIgnoreProperties("reservation")
    private Score score
    */

    public Reservation() {
    }

    public Reservation(int idReservation, Date startDate, Date devolutionDate, String status, Library lib, Client client, Score score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.lib = lib;
        this.client = client;
        this.score = score;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Library getLib() {
        return lib;
    }

    public void setLib(Library lib) {
        this.lib = lib;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", startDate=" + startDate +
                ", devolutionDate=" + devolutionDate +
                ", status='" + status + '\'' +
                ", lib=" + lib +
                ", client=" + client +
                ", score=" + score +
                '}';
    }
}
