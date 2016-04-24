package com.github.u1152.uportal.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Илья on 20.04.2016.
 */
@Entity
@Table(name = "articles")
public class Articals {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "TextArticals")
    private String TextArticals;

    @Column(name = "Description")
    private String Description;

    @Column(name = "DateCreate")
    private String DateCreate;

    @ManyToMany(mappedBy = "articles")
    private Set<Author> art = new HashSet<>();

    public Articals() {
    }

    public Articals(int ID, String TextArticals, String Description, String DateCreate) {
        this.id = ID;
        this.TextArticals = TextArticals;
        this.Description = Description;
        this.DateCreate = DateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public String getTextArticals() {
        return TextArticals;
    }

    public void setTextArticals(String TextArt) {
        this.TextArticals = TextArt;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(String DateCreate) {
        this.DateCreate = DateCreate;
    }

    public Set<Author> getArt() {
        return art;
    }

    public void setArt(Set<Author> art) {
        this.art = art;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Articals articals = (Articals) o;

        return getId() == articals.getId();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getTextArticals().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getDateCreate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Articals{" +
                "id=" + id +
                ", TextArticals='" + TextArticals + '\'' +
                ", Description='" + Description + '\'' +
                ", DateCreate='" + DateCreate + '\'' +
                '}';
    }
}
