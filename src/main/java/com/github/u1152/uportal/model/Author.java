package com.github.u1152.uportal.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * author Aleksandr
 */
@Entity
@Table(name = "author")

public class Author {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "Patronymic")
    private String midName;

    @Column(name = "SurName")
    private String lastName;

    @Column(name = "eMail")
    private String eMail;

    @Column(name = "image")
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "articles_author",
            joinColumns = {@JoinColumn(name = "IDAuthor",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "IDArt", referencedColumnName = "id")})
    private Set<Articals> articles = new HashSet<>(0);

    public Author() {
    }

    public Author(int id, String firstName, String midName, String lastName, String eMail, String image) {
        this.id = id;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.image = image;
    }

    public Author(String firstName, String midName, String lastName, String eMail, String image) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.image = image;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (getId() != author.getId()) return false;
        if (!getFirstName().equals(author.getFirstName())) return false;
        if (getMidName() != null ? !getMidName().equals(author.getMidName()) : author.getMidName() != null)
            return false;
        if (!getLastName().equals(author.getLastName())) return false;
        if (geteMail() != null ? !geteMail().equals(author.geteMail()) : author.geteMail() != null) return false;
        return getImage() != null ? getImage().equals(author.getImage()) : author.getImage() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + (getMidName() != null ? getMidName().hashCode() : 0);
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + (geteMail() != null ? geteMail().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", IMAGE='" + image + '\'' +
                '}';
    }

}
