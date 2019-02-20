package brainstation.booksapi.controller;

import brainstation.booksapi.core.book.service.BookService;
import brainstation.booksapi.exceptions.RestExceptionInterceptor;
import brainstation.booksapi.model.Book;
import brainstation.booksapi.util.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(@NotNull BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public ResponseEntity<CustomResponse> getAllBooks(){
        List<Book> bookList = this.bookService.getAllBooks();

        if(bookList == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't return all books" , null) , HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new CustomResponse("ok", bookList), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<CustomResponse> getBookById(@PathVariable("id") Integer id){
        Book responseBook = this.bookService.getBookById(id);

        if(responseBook == null){
            return new ResponseEntity<>(new CustomResponse("Book not found", null), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CustomResponse("ok", responseBook), HttpStatus.OK);
    }

    @PostMapping("/book/")
    public ResponseEntity<CustomResponse> createBook(@Validated(RestExceptionInterceptor.class) @RequestBody Book book){
        Book createdBook = this.bookService.createBook(book.getName(), book.getAuthor());

        if(createdBook == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't create book with name: " + book.getName() + " and author: " + book.getAuthor(),null)
                                                            , HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new CustomResponse("ok", createdBook), HttpStatus.OK);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<CustomResponse> updateBook(@PathVariable("id") Integer id,
                                                    @Validated(RestExceptionInterceptor.class) @RequestBody Book book){

        Book updatedBook = this.bookService.updateBook(id, book.getName(), book.getAuthor());

        if(updatedBook == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't update book with new name: " + book.getName() + " and author: " + book.getAuthor(),null)
                    , HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new CustomResponse("ok", updatedBook), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<CustomResponse> deleteBook(@PathVariable("id") Integer id){
        Boolean successful = this.bookService.deleteBook(id);

        if(!successful) {
            return new ResponseEntity<>(new CustomResponse("Couldn't delete book with id :" + id, null) , HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new CustomResponse("ok", null),HttpStatus.OK);
    }
}
