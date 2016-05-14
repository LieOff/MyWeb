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
    private String textArticals;

    @Column(name = "Description")
    private String description;

    @Column(name = "DateCreate")
    private String dateCreate;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "articles_author",
            joinColumns = {@JoinColumn(name = "IDArt",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "IDAuthor", referencedColumnName = "id")})
    private Set<Author> authors = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "articles_articalprop",
            joinColumns = {@JoinColumn(name = "IDArt",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "IDArtProp", referencedColumnName = "id")})
    private Set<ArticalsProp> articalsProps = new HashSet<>(0);


    public Articals() {
    }

    public Articals(int ID, String TextArticals, String Description, String DateCreate) {
        this.id = ID;
        this.textArticals = TextArticals;
        this.description = Description;
        this.dateCreate = DateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public String getTextArticals() {
        return textArticals;
    }

    public void setTextArticals(String TextArt) {
        this.textArticals = TextArt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String DateCreate) {
        this.dateCreate = DateCreate;
    }

    public Set<ArticalsProp> getArticalsProps() {
        return articalsProps;
    }

    public void setArticalsProps(Set<ArticalsProp> articalsProp) {
        this.articalsProps = articalsProp;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> art) {
        this.authors = art;
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
                ", TextArticals='" + textArticals + '\'' +
                ", Description='" + description + '\'' +
                ", DateCreate='" + dateCreate + '\'' +
                '}';
    }
}
