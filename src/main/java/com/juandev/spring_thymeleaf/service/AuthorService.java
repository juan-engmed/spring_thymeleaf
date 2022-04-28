package com.juandev.spring_thymeleaf.service;

import com.juandev.spring_thymeleaf.entity.Author;
import com.juandev.spring_thymeleaf.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.stream.StreamSupport.stream;

@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository repository;

    public List<Author> getAuthorList(){

        var authorList = StreamSupport.stream(repository.findAll().spliterator(),false)
                .collect(Collectors.toList());

        return authorList;

    }


}
