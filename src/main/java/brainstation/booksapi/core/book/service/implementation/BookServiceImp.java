package brainstation.booksapi.core.book.service.implementation;

import brainstation.booksapi.core.book.respository.BookRepository;
import brainstation.booksapi.core.book.service.BookService;
import brainstation.booksapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImp(@NotNull BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(Integer id) {
        Optional<Book> bookOptional = this.bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book createBook(String name, String author) {
        return this.bookRepository.save(new Book(name, author));
    }

    @Override
    public Boolean deleteBook(Integer id) {
        this.bookRepository.deleteById(id);
        return true;
    }

    @Override
    public Book updateBook(Integer id, String name, String author) {
        int rowsUpdated = this.bookRepository.updateBookById(id, name, author);
        if(rowsUpdated > 0){
            return this.getBookById(id);
        }
        return null;
    }
}
