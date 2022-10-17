package com.reto3Mintic.reto3Mintic.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "library")
public class Library implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = true, length = 45)
    private String name;

    @Column(name = "target", nullable = true, length = 45)
    private String target;

    @Column(name = "capacity", nullable = true)
    private int capacity;

    @Column(name = "description", nullable = true, length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("libs")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"lib", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"lib", "client"})
    private List<Reservation> reservations;

    public Library() {
    }

    public Library(int id, String name, String target, int capacity, String description, Category category, List<Message> messages, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.target = target;
        this.capacity = capacity;
        this.description = description;
        this.category = category;
        this.messages = messages;
        this.reservations = reservations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", target='" + target + '\'' +
                ", capacity=" + capacity +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", messages=" + messages +
                ", reservations=" + reservations +
                '}';
    }
}
