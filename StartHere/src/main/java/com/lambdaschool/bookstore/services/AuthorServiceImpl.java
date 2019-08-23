package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authors")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    public AuthorRepository authorsrepo;

    @Override
    public List<Author> showAll(){

        List<Author> authorList = new ArrayList<>();

        authorsrepo.findAll().iterator().forEachRemaining(authorList::add);

        return authorList;
    }

    @Override
    public void save(Author author){
        Author newAuthor = new Author();

        newAuthor.setFirstname(author.getFirstname());
        newAuthor.setLastname(author.getLastname());

        for(Book b : author.getBooks()){
            newAuthor.getBooks().add(b);
        }

        authorsrepo.save(newAuthor);
    }

    @Override
    public void update(Author author, long id){
        Author currentAuthor = authorsrepo.findByAuthorid(id);

        if(author.getFirstname() != null){
            currentAuthor.setFirstname(author.getFirstname());
        }
        if(author.getLastname() != null){
            currentAuthor.setLastname(author.getLastname());
        }

        currentAuthor.setBooks(null);

        for(Book b : author.getBooks()){
            currentAuthor.getBooks().add(b);
        }
    }
}
