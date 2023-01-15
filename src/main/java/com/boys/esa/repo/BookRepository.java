package com.boys.esa.repo;

import com.boys.esa.models.Author;
import com.boys.esa.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    Book findByName(String name);

    List<Book> findAllByAuthor(Author author);

    @Transactional
    void deleteAllByAuthor(Author author);
}
