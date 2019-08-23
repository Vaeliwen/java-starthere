package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    List<Author> findAllByLastname(String lastname, Pageable pageable);

    Author findByAuthorid(long id);
}
