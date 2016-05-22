package com.github.u1152.uportal.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Илья on 20.04.2016.
 */
@Entity
@Table(name = "news")
public class News {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "Header")
    private String header;

    @Column(name = "TextNews")
    private String text;

    @Column(name = "DateAdd", columnDefinition="DATE")
    private Date dateCreate;

    @Column(name = "Image")
    private String image;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "author_news",
            joinColumns = {@JoinColumn(name = "IDNews",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "IDAut", referencedColumnName = "id")})
    private Set<Author> authors = new HashSet<>(0);

    public News() {
    }

    public News(int ID, String Header, String Text, Date DateCreate, String Image) {
        this.id = ID;
        this.header = Header;
        this.text = Text;
        this.dateCreate = DateCreate;
        this.image = Image;
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

    public String getText() {
        return text;
    }

    public void setText(String Text) {
        this.text = Text;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String Header) {
        this.header = Header;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date DateCreate) {
        this.dateCreate = DateCreate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String Image) {
        this.image = Image;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        return getId() == news.getId();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getText().hashCode();
        result = 31 * result + (getHeader() != null ? getHeader().hashCode() : 0);
        result = 31 * result + getDateCreate().hashCode();
        return result;
    }

}
