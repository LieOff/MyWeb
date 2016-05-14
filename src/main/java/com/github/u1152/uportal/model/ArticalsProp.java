package com.github.u1152.uportal.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Илья on 20.04.2016.
 */
@Entity
@Table(name = "articalprop")
public class ArticalsProp {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "Description")
    private String description;

    @Column(name = "ValueOf")
    private String valueOf;


    @Column(name = "Usege",columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean usege;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "articalsProps")
    private Set<Articals> articles = new HashSet<>();


    public ArticalsProp() {
    }

    public ArticalsProp(int ID, String Description, boolean Usege) {
        this.id = ID;
        this.description = Description;
        this.usege = Usege;
    }
    public Set<Articals> getArticles() {
        return this.articles;
    }

    public void setArticles(Set<Articals> articles) {
        this.articles = articles;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }
    public String getValueOf() {
        return valueOf;
    }

    public void setValueOf(String ValueOf) {
        this.valueOf = ValueOf;
    }

    public void setUsege(Boolean Usege) {
        this.usege = Usege;
    }

    public Boolean getUsege() {
        return usege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticalsProp articalsProp = (ArticalsProp) o;

        return getId() == articalsProp.getId();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUsege().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

}
