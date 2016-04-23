package com.github.u1152.uportal.model;

import javax.persistence.*;
import java.util.Collection;

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
    public  Articals(){}

    public  Articals(int ID,String TextArticals, String Description, String DateCreate){
        this.id = ID;
        this.TextArticals = TextArticals;
        this.Description = Description;
        this.DateCreate = DateCreate;
    }
    public int getId(){return id;}
    public String getTextArticals(){return TextArticals;}
    public String getDescription(){return Description;}
    public String getDateCreate(){return DateCreate;}
    public void setId(int ID){this.id = ID;}
    public void setTextArticals(String TextArt){this.TextArticals = TextArt;}
    public void setDescription(String Description){this.Description = Description;}
    public void setDateCreate(String DateCreate){this.DateCreate = DateCreate;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Articals articals = (Articals) o;

        if (getId() != articals.getId()) return false;
        else {return true;}
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


    @ManyToMany(mappedBy = "courses")
    private Collection<Author> art;

    public Collection<Author> getArt() {
        return art;
    }

    public void setArt(Collection<Author> art) {
        this.art = art;
    }
}
