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
    private String title;

    @Column(name = "DateStart", columnDefinition="DATETIME")
    private Date start;

    @Column(name = "DateEnd", columnDefinition="DATETIME")
    private Date end;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "author_news",
            joinColumns = {@JoinColumn(name = "IDNews",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "IDAut", referencedColumnName = "id")})
    private Set<Author> authors = new HashSet<>(0);

    public Event() {
    }

    public Event(int ID, String Header, Date Start, Date Image) {
        this.id = ID;
        this.title = Header;
        this.start = Start;
        this.end = Image;
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


    public String getTitle() {
        return title;
    }

    public void setTitle(String Header) {
        this.title = Header;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date DateCreate) {
        this.start = DateCreate;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date DateEnd) {
        this.end = DateEnd;
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
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getStart().hashCode();
        return result;
    }

}
