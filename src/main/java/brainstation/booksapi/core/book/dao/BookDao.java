package brainstation.booksapi.core.book.dao;

import brainstation.booksapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookDao extends JpaRepository<Book, Integer> {

    @Override
    Optional<Book> findById(Integer integer);

    @Override
    Book save(Book book);

    @Override
    void deleteById(Integer integer);

    @Modifying
    @Query("update Book book set book.name = :bookName, book.author = :bookAuthor where book.id = :bookId")
    int updateBookById(Integer bookId, String bookName, String bookAuthor);

}
