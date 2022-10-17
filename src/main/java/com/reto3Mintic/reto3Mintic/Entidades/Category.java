
package com.reto3Mintic.reto3Mintic.Entidades;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = true, length = 45)
    private String name;

    @Column(name = "description", nullable = true, length = 250)
    private String description;


    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties
    private List<Library> libs;


    public Category() {
    }

    public Category(int id, String name, String description, List<Library> libs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.libs = libs;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Library> getLibs() {
        return libs;
    }

    public void setLibs(List<Library> libs) {
        this.libs = libs;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", libs=" + libs +
                '}';
    }
}
