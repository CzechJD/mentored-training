package test.collections;

import com.example.collections.Book;
import com.example.collections.LibraryService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testCollections {
    @Test
    public void getUserBooks() {
        LibraryService libraryService = new LibraryService();
        libraryService.takeBook(1L, 3L);
        libraryService.takeBook(1L, 4L);
        List<Book> expectedBooks = Arrays.asList(
                new Book("Зерцалия", "Евгений Гаглоев", 2018, 3L),
                new Book("Mara and Morok", "Leah Arden", 2020, 4L));
        List<Book> actualBooks = libraryService.getUserBooks(1L);

        assertEquals(expectedBooks, actualBooks);
        assertEquals(new ArrayList<>(), libraryService.getUserBooks(2L));

        assertThrows(IllegalArgumentException.class, () -> new LibraryService().getUserBooks(0L));

    }

    @Test
    public void takeBook() {
        LibraryService libraryService = new LibraryService();
        assertEquals(true, libraryService.takeBook(1L, 1L));
        assertEquals(true, libraryService.takeBook(2L, 3L));
        assertEquals(false, libraryService.takeBook(2L, 1L));

        assertThrows(IllegalArgumentException.class, () -> new LibraryService().takeBook(0L, 1L));
        assertThrows(IllegalArgumentException.class, () -> new LibraryService().takeBook(0L, 0L));
        assertThrows(IllegalArgumentException.class, () -> new LibraryService().takeBook(1L, 0L));
    }

    @Test
    public void returnBook() {
        LibraryService libraryService = new LibraryService();
        libraryService.takeBook(1L, 2L);
        assertEquals(true, libraryService.returnBook(1L, 2L));
        assertEquals(false, libraryService.returnBook(1L, 3L));
        assertThrows(IllegalArgumentException.class, () -> new LibraryService().returnBook(1L, 0L));
        assertThrows(IllegalArgumentException.class, () -> new LibraryService().returnBook(0L, 0L));
        assertThrows(IllegalArgumentException.class, () -> new LibraryService().returnBook(0L, 1L));

    }
}
