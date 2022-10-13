package com.reto3Mintic.reto3Mintic.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Message")
public class Message {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "messageText", nullable = true, length = 250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "id_library", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Library library;

    public Message() {
    }

    public Message(int id, String messageText, Library library) {
        this.id = id;
        this.messageText = messageText;
        this.library = library;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", messageText='" + messageText + '\'' +
                ", library=" + library +
                '}';
    }
}
