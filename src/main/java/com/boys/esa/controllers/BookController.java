package com.boys.esa.controllers;

import com.boys.esa.models.Author;
import com.boys.esa.models.Book;
import com.boys.esa.repo.AuthorRepository;
import com.boys.esa.repo.BookRepository;
import com.boys.esa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class BookController {

    BookService bookService;
    BookRepository bookRepository;
    AuthorRepository authorRepository;

    public BookController(BookService bookService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping(value = "/books")
    public String getBookList(Model model) {

        model.addAttribute("name", bookService.getBookList(bookRepository));
        return "greeting";
    }

    @GetMapping("/authors/{id}/books")
    public String getBookListByAuthor(@PathVariable(value = "id") UUID id, Model model) {
        Author author = authorRepository.findById(id).orElseThrow(NullPointerException::new);
        List<Book> bookList = bookRepository.findAllByAuthor(author);
        model.addAttribute("name", bookList.stream().map(Book::getName).collect(Collectors.toList()));
        return "greeting";
    }

    @GetMapping("/authors/books")
    public String getBookListByAuthor(Model model) {
        Map<String, List<String>> map = new HashMap<>();
        List<Author> authorList = authorRepository.findAll();
        for (Author author : authorList) {
            List<Book> bookList = bookRepository.findAllByAuthor(author);
            map.put(author.getSurname(), bookList.stream().map(Book::getName).collect(Collectors.toList()));
        }
        model.addAttribute("name", map);
        return "greeting";
    }
}
