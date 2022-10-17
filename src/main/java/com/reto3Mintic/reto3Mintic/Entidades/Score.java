
package com.reto3Mintic.reto3Mintic.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "score")
public class Score implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idScore", unique = true, nullable = false)
    private int idScore;

    @Column(name = "score", nullable = true)
    private int scoreScore;

    @Column(name = "message", nullable = true, length = 250)
    private String messageScore;

    /*
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;
    */

    public Score() {
    }

    public Score(int idScore, int scoreScore, String messageScore) {
        this.idScore = idScore;
        this.scoreScore = scoreScore;
        this.messageScore = messageScore;
    }

    public int getIdScore() {
        return idScore;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public int getScoreScore() {
        return scoreScore;
    }

    public void setScoreScore(int scoreScore) {
        this.scoreScore = scoreScore;
    }

    public String getMessageScore() {
        return messageScore;
    }

    public void setMessageScore(String messageScore) {
        this.messageScore = messageScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "idScore=" + idScore +
                ", scoreScore=" + scoreScore +
                ", messageScore='" + messageScore + '\'' +
                '}';
    }
}
