package com.juandev.spring_thymeleaf.repository;

import com.juandev.spring_thymeleaf.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
