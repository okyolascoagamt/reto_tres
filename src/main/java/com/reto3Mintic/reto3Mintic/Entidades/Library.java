package com.reto3Mintic.reto3Mintic.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Library")
public class Library {

    @Id
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
    @JoinColumn(name = "id_category", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Category category;

    public Library() {
    }

    public Library(int id, String name, String target, int capacity, String description, Category category) {
        this.id = id;
        this.name = name;
        this.target = target;
        this.capacity = capacity;
        this.description = description;
        this.category = category;
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

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", target='" + target + '\'' +
                ", capacity=" + capacity +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
