package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.services.AuthorService;
import com.lambdaschool.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    BookService bookService;


    @PutMapping(value = "books/{id}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> updateBookInfo(HttpServletRequest request, @RequestBody Book updateBook, @PathVariable long id){
        bookService.update(updateBook, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/books/{bookid}/authors/{authorid}", produces = {"application/json"})
    public ResponseEntity<?> addAuthorToBook(@PathVariable long bookid, @PathVariable long authorid){
        bookService.addAuthor(bookid, authorid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
