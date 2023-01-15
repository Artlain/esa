package com.boys.esa.services;

import com.boys.esa.models.Author;
import com.boys.esa.models.Book;
import com.boys.esa.repo.AuthorRepository;
import com.boys.esa.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service(value = "authorService")
public class AuthorService {

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public Book getFirstBookByAuthor(Author author) {
        List<Book> bookList = new ArrayList<>();
        bookList = bookRepository.findAllByAuthor(author);
        if (!bookList.isEmpty()) {
            bookList.sort(Comparator.comparing(Book::getPublishDate));
            return bookList.get(0);
        }
        return null;
    }

    public static List<String> getAuthorList(AuthorRepository authorRepository) {
        List<String> authorList = new ArrayList<>();
        for (Author author : authorRepository.findAll()) {
            authorList.add(author.getName() + " " + author.getSurname());
        }
        return authorList;
    }
}
