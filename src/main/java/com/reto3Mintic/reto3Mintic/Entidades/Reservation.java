package com.reto3Mintic.reto3Mintic.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate", nullable = false )
    private Date startDate;

    @Column(name = "devolutionDate", nullable = true)
    private Date devolutionDate;

    @Column(name = "status", nullable = true, length = 45)
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_library", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Library library;

    public Reservation() {
    }

    public Reservation(int id, Date startDate, Date devolutionDate, String status, Client client, Library library) {
        this.id = id;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.client = client;
        this.library = library;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", devolutionDate=" + devolutionDate +
                ", status='" + status + '\'' +
                ", client=" + client +
                ", library=" + library +
                '}';
    }
}
