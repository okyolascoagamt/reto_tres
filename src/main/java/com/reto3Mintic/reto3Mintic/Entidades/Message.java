
package com.reto3Mintic.reto3Mintic.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage", unique = true, nullable = false)
    private int idMessage;

    @Column(name = "messageText", nullable = true, length = 250)
    private String messageText;


    @ManyToOne
    @JoinColumn(name = "libId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Library lib;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Message() {
    }

    public Message(int idMessage, String messageText, Library lib, Client client) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.lib = lib;
        this.client = client;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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

    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", messageText='" + messageText + '\'' +
                ", lib=" + lib +
                ", client=" + client +
                '}';
    }
}
