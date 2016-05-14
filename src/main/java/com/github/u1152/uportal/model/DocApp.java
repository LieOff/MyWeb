package com.github.u1152.uportal.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Илья on 20.04.2016.
 */
@Entity
@Table(name = "docregapp")
public class DocApp {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "Header")
    private String header;

    @Column(name = "RegDate")
    private String regdate;

    @Column(name = "OtprDocDate")
    private String otprDocDate;

    @Column(name = "FileName")
    private String fileName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "author_docregapp",
            joinColumns = {@JoinColumn(name = "IDDApp",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "IDAut", referencedColumnName = "id")})
    private Set<Author> authors = new HashSet<>(0);

    public DocApp() {
    }

    public DocApp(int ID, String Header, String RegDate, String OtprDocDate, String FileName) {
        this.id = ID;
        this.header = Header;
        this.regdate = RegDate;
        this.otprDocDate = OtprDocDate;
        this.fileName = FileName;
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

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String Regdate) {
        this.regdate = Regdate;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String Header) {
        this.header = Header;
    }

    public String getOtprDocDate() {
        return otprDocDate;
    }

    public void setOtprDocDate(String OtprDocDate) {
        this.otprDocDate = OtprDocDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String FileName) {
        this.fileName = FileName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocApp news = (DocApp) o;

        return getId() == news.getId();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getRegdate().hashCode();
        result = 31 * result + (getHeader() != null ? getHeader().hashCode() : 0);
        result = 31 * result + getOtprDocDate().hashCode();
        return result;
    }

}
