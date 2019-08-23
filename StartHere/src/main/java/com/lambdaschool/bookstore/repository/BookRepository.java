package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    List<Book> findAllByCopy(int copy, Pageable pageable);
    
    Book findByBooktitle(String booktitle);

    Book findByBookid(long bookid);
}
