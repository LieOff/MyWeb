package com.github.u1152.uportal.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Илья on 20.04.2016.
 */
@Entity
@Table(name = "event")
public class Event {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "DateStart", columnDefinition="DATETIME")
    private Date dateStart;

    @Column(name = "DateEnd", columnDefinition="DATETIME")
    private Date dateEnd;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "author_news",
            joinColumns = {@JoinColumn(name = "IDNews",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "IDAut", referencedColumnName = "id")})
    private Set<Author> authors = new HashSet<>(0);

    public Event() {
    }

    public Event(int ID, String Header, Date DateStart, Date Image) {
        this.id = ID;
        this.name = Header;
        this.dateStart = DateStart;
        this.dateEnd = Image;
    }
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> art) {
        this.authors = art;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }


    public String getName() {
        return name;
    }

    public void setName(String Header) {
        this.name = Header;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date DateCreate) {
        this.dateStart = DateCreate;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date DateEnd) {
        this.dateEnd = DateEnd;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event news = (Event) o;

        return getId() == news.getId();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getDateStart().hashCode();
        return result;
    }

}
