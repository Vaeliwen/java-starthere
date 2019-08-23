package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false, unique = true, name = "title")
    private String booktitle;

    @Column(nullable = false, unique = true, name = "ISBN")
    private String isbn;

    @Column(name = "copy")
    private Integer copy;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties
    private List<Author> authors;

    public Book(String booktitle, String isbn, Integer copy) {
        this.booktitle = booktitle;
        this.isbn = isbn;
        this.copy = copy;
    }

    public Book() {
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCopy() {
        return copy;
    }

    public void setCopy(Integer copy) {
        this.copy = copy;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
