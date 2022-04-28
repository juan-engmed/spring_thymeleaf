package com.juandev.spring_thymeleaf.service;

import com.juandev.spring_thymeleaf.BookDTO;
import com.juandev.spring_thymeleaf.entity.Book;
import com.juandev.spring_thymeleaf.exception.SearchNotFoundException;
import com.juandev.spring_thymeleaf.repository.AuthorRepository;
import com.juandev.spring_thymeleaf.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository repository;
    //private final AuthorRepository authorRepository;

    public void save(Book book){

//        var author = authorRepository.findById(bookDTO.getAuthorId())
//                .orElseThrow(() -> new SearchNotFoundException("Autor", bookDTO.getAuthorId()));
//
//        var book = new Book();
//
//        book.setName(bookDTO.getName());
//        book.setAuthor(author);

        repository.save(book);
    }

    public List<Book> findAll() {

        var bookList = StreamSupport.stream(repository.findAll().spliterator(),false)
                .collect(Collectors.toList());

        return bookList;
    }

    public Book findById(Long id) {

        var book = repository.findById(id)
                .orElseThrow(() -> new SearchNotFoundException("Livro", id));

        return book;
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }
}
