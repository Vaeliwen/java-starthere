package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @Column(nullable = false, name = "lname")
    private String lastname;

    @Column(nullable = false, name = "fname")
    private String firstname;

    @Column(name = "full_name")
    private String fullname;

    @ManyToMany
    @JoinTable(
            name = "books",
            joinColumns = @JoinColumn(name = "author_name"),
            inverseJoinColumns = @JoinColumn(name = "book_title")
    )
    private List<Book> books;

    public Author(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
        fullname = firstname + " " + lastname;
    }

    public Author() {
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String toString(){
        return "Author:{" +
                "authorid: " + authorid + ", fullname: " + fullname + "}";
    }
}
