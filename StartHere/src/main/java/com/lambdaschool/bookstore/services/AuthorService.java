package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> showAll();

    public void save(Author author);

    public void update(Author author, long id);
}
