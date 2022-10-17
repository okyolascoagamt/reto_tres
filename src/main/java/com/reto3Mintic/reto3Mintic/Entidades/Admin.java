package com.reto3Mintic.reto3Mintic.Entidades;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {

    @Id
    @Column(name = "idAmin", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmin;

    @Column(name = "name", nullable = true, length = 250)
    private String name;

    @Column(name = "email", nullable = true, length = 45)
    private String email;

    @Column(name = "password", nullable = true, length = 45)
    private String password;

    public Admin() {
    }

    public Admin(int idAdmin, String name, String email, String password) {
        this.idAdmin = idAdmin;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
