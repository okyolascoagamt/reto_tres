package com.reto3Mintic.reto3Mintic.Entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = true, length = 250)
    private String name;

    @Column(name = "age", nullable = true)
    private int age;

    @Column(name = "email", nullable = true, length = 45)
    private String email;

    @Column(name = "password", nullable = true, length = 45)
    private String password;

    public Client() {
    }

    public Client(int id, String name, int age, String email, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
