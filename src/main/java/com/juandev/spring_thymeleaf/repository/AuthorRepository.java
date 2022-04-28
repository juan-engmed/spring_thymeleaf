package com.juandev.spring_thymeleaf.repository;

import com.juandev.spring_thymeleaf.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
