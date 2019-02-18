package brainstation.booksapi;

import brainstation.booksapi.core.book.dao.implementation.BookDaoImp;
import brainstation.booksapi.core.book.service.implementation.BookServiceImp;
import brainstation.booksapi.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {

    @Mock
    BookDaoImp bookDao;

    @InjectMocks
    BookServiceImp bookService;

    @Autowired
    BookServiceImp bookServiceImp;

    /*
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.bookService = new BookServiceImp(bookDao);
    }
    */

    /*@Test
    public void getBookByIdTest() {
        when(bookService.createBook(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(new Book("1", "name", "author"));

        Book resultBook = this.bookService.createBook("1", "name", "author");

        assertNotNull(resultBook);
        assertEquals(resultBook.getId(), "1");
    }

    @Test
    public void getAllBooksTest(){
        List<Book> listToReturn = new LinkedList<>();
        listToReturn.add(new Book("1", "name", "author"));
        listToReturn.add(new Book("2", "name2", "author2"));

        when(this.bookService.getAllBooks()).thenReturn(listToReturn);

        List<Book> returnedList = this.bookService.getAllBooks();
        assertEquals(2, returnedList.size());
    }

    @Test
    public void createBookTest() {
        Book testBook = new Book("10", "Las aventuras de Charlie","Charlie");

        when(this.bookService.createBook(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(testBook);

        Book resultBook = bookService.createBook(testBook.getId(), testBook.getName(), testBook.getAuthor());

        assertEquals(testBook, resultBook);
    }


    @Test
    public void createBookWithNoIdTest(){
        when(this.bookService.createBook(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(null);

        Book resultBook = bookService.createBook(null, "testName", "testAuthor");
        assertNull(resultBook);
    }


    @Test
    public void deleteBookTest(){
        when(this.bookService.deleteBook(Mockito.any())).thenReturn(true);

        assertTrue(this.bookService.deleteBook("id"));
    }

    @Test
    public void UpdateBookTest(){
        Book bookToUpdate = new Book("testId", "testName", "testAuthor");

        when(this.bookService.updateBook(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(new Book("testId", "newTestName", "newTestAuthor"));

        Book updatedBook = this.bookService.updateBook("id", "newTestName", "newTestAuthor");


        assertEquals(updatedBook.getName(), "newTestName");
        assertEquals(updatedBook.getAuthor(), "newTestAuthor");

    }
*/
}

