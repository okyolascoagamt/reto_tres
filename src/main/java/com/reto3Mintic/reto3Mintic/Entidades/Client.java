package com.reto3Mintic.reto3Mintic.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient", unique = true, nullable = false)
    private int idClient;

    @Column(name = "name", nullable = true, length = 250)
    private String name;

    @Column(name = "age", nullable = true)
    private int age;

    @Column(name = "email", nullable = true, length = 45)
    private String email;

    @Column(name = "password", nullable = true, length = 45)
    private String password;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

    public Client() {
    }

    public Client(int idClient, String name, int age, String email, String password, List<Message> messages, List<Reservation> reservations) {
        this.idClient = idClient;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.messages = messages;
        this.reservations = reservations;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", messages=" + messages +
                ", reservations=" + reservations +
                '}';
    }
}
