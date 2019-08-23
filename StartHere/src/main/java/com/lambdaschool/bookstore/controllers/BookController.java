package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    BookService bookService;

    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks(HttpServletRequest request){
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Book> allBooks = bookService.showAll();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

}
