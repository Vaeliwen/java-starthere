package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository booksrepo;

    @Autowired
    private AuthorRepository authorrepo;

    @Override
    public List<Book> showAll(){

        List<Book> bookList = new ArrayList<>();

        booksrepo.findAll().iterator().forEachRemaining(bookList::add);

        return bookList;
    }

    @Override
    public void addAuthor(long bookid, long authorid){
        Book currentBook = booksrepo.findByBookid(bookid);
        Author currentAuthor = authorrepo.findByAuthorid(authorid);

        currentAuthor.getBooks().add(currentBook);

        authorrepo.save(currentAuthor);
    }

    @Override
    public void update(Book book, long id){
        Book currentBook = booksrepo.findByBookid(id);

        if(currentBook != null){
            if(id == currentBook.getBookid()) {
                if (book.getBooktitle() != null) {
                    currentBook.setBooktitle(book.getBooktitle());
                }
                if (book.getIsbn() != null) {
                    currentBook.setIsbn(book.getIsbn());
                }
                if (book.getCopy() != null) {
                    currentBook.setCopy(book.getCopy());
                }
                booksrepo.save(currentBook);
            }
            else{
                throw new ResourceNotFoundException(id + " not current book");
            }
        }
        else{
            throw new ResourceNotFoundException(book.getBooktitle());
        }
    }
}
