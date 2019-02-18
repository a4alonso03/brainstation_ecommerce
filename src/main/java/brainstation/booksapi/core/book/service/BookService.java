package brainstation.booksapi.core.book.service;

import brainstation.booksapi.model.Book;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;


public interface BookService {

    @Transactional
    Book getBookById(Integer id);

    @Transactional
    List<Book> getAllBooks();

    @Transactional
    Book createBook(String name, String author);

    @Transactional
    Boolean deleteBook(Integer id);

    @Transactional
    Book updateBook(Integer id, String name, String author);

}
