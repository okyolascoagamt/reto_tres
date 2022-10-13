package com.reto3Mintic.reto3Mintic.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Score")
public class Score {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "score", nullable = true)
    private int score;

    @Column(name = "message", nullable = true, length = 250)
    private String message;

    @ManyToOne
    @JoinColumn(name = "id_reservation", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Reservation reservation;

    public Score() {
    }

    public Score(int id, int score, String message, Reservation reservation) {
        this.id = id;
        this.score = score;
        this.message = message;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", score=" + score +
                ", message='" + message + '\'' +
                ", reservation=" + reservation +
                '}';
    }
}
