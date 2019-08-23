package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;

import java.util.List;

public interface BookService {

    public List<Book> showAll();

    public void addAuthor(long bookid, long authorid);

    public void update(Book book, long id);
}
