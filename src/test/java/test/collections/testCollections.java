package test.collections;

import com.example.collections.Book;
import com.example.collections.LibraryService;
import com.example.collections.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testCollections {
    private static LibraryService libraryServiceTest;
    @BeforeEach
    void setUp() {
        libraryServiceTest = new LibraryService();

        libraryServiceTest.addBook(1L, new Book("The Infernal Devices", "Kassandra Clare", 2010, 1L));
        libraryServiceTest.addBook(2L, new Book("Часовой ключ", "Наталья Щерба", 2011, 2L));
        libraryServiceTest.addBook(3L, new Book("Зерцалия", "Евгений Гаглоев", 2018, 3L));
        libraryServiceTest.addBook(4L, new Book("Mara and Morok", "Leah Arden", 2020, 4L));
        libraryServiceTest.addBook(5L, new Book("The Subtle Art of Not Giving a F*ck", "Mark Manson", 2016, 5L));

        libraryServiceTest.addUser(1L, new User("William", 17, 1L));
        libraryServiceTest.addUser(2L, new User("Charlotte", 23, 2L));
        libraryServiceTest.addUser(3L, new User("James", 17, 3L));
        libraryServiceTest.addUser(4L, new User("Henry", 23, 4L));
        libraryServiceTest.addUser(5L, new User("Tessa", 16, 5L));
    }



    @Test
    void getUserBooks() {
        libraryServiceTest.takeBook(1L, 3L);
        libraryServiceTest.takeBook(1L, 4L);

        List<Book> expectedBooks = Arrays.asList(
                new Book("Зерцалия", "Евгений Гаглоев", 2018, 3L),
                new Book("Mara and Morok", "Leah Arden", 2020, 4L));
        List<Book> actualBooks = libraryServiceTest.getUserBooks(1L);

        assertEquals(expectedBooks, actualBooks);
        assertEquals(new ArrayList<>(), libraryServiceTest.getUserBooks(2L));

        assertThrows(IllegalArgumentException.class, () -> new LibraryService().getUserBooks(0L));

    }

    @Test
    void takeBook() {
        assertTrue(libraryServiceTest.takeBook(1L, 1L));
        assertTrue(libraryServiceTest.takeBook(2L, 3L));
        assertFalse(libraryServiceTest.takeBook(2L, 1L));

        assertThrows(IllegalArgumentException.class, () -> new LibraryService().takeBook(0L, 1L));
        assertThrows(IllegalArgumentException.class, () -> new LibraryService().takeBook(0L, 0L));
        assertThrows(IllegalArgumentException.class, () -> new LibraryService().takeBook(1L, 0L));
    }

    @Test
    void returnBook() {
        libraryServiceTest.takeBook(1L, 2L);
        assertEquals(true, libraryServiceTest.returnBook(1L, 2L));
        assertEquals(false, libraryServiceTest.returnBook(1L, 3L));

        assertThrows(IllegalArgumentException.class, () -> new LibraryService().returnBook(1L, 0L));
        assertThrows(IllegalArgumentException.class, () -> new LibraryService().returnBook(0L, 0L));
        assertThrows(IllegalArgumentException.class, () -> new LibraryService().returnBook(0L, 1L));

    }
}
