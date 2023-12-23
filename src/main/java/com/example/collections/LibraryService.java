package com.example.collections;

import java.util.ArrayList;
import java.util.HashMap;

public class LibraryService {
    private HashMap<Long, Book> books;
    private HashMap<Long, User> users;
    private HashMap<Long, ArrayList<Long>> userBorrowedBooks = new HashMap<>();

    public LibraryService() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
        this.userBorrowedBooks = new HashMap<>();

        this.books.put(1L, new Book("The Infernal Devices", "Kassandra Clare", 2010, 1L));
        this.books.put(2L, new Book("Часовой ключ", "Наталья Щерба", 2011, 2L));
        this.books.put(3L, new Book("Зерцалия", "Евгений Гаглоев", 2018, 3L));
        this.books.put(4L, new Book("Mara and Morok", "Leah Arden", 2020, 4L));
        this.books.put(5L, new Book("The Subtle Art of Not Giving a F*ck", "Mark Manson", 2016, 5L));

        this.users.put(1L, new User("William", 17, 1L));
        this.users.put(2L, new User("Charlotte", 23, 2L));
        this.users.put(3L, new User("James", 17, 3L));
        this.users.put(4L, new User("Henry", 23, 4L));
        this.users.put(5L, new User("Tessa", 16, 5L));

    }

    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
    }

    public ArrayList<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public ArrayList<Book> getAllAvailableBooks() {
        ArrayList<Book> availableBook = new ArrayList<>();
        for (Book book : books.values()) {
            boolean isBookTaken = false;
            for (ArrayList<Long> takenBook : userBorrowedBooks.values()) {
                if (takenBook.contains(book.getBookId())) {
                    isBookTaken = true;
                    break;
                }
            }
            if (!isBookTaken) {
                availableBook.add(book);
            }
        }

        return availableBook;
    }

    public ArrayList<Book> getUserBooks(Long userId) {
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("Пользователь с ID: " + userId + ", не найден");
        }
        ArrayList<Book> listBook = new ArrayList<>();

        if (userBorrowedBooks.containsKey(userId)) {
            ArrayList<Long> userBook = userBorrowedBooks.get(userId);
            for (Long book : userBook) {
                listBook.add(books.get(book));
            }
        }
        return listBook;
    }

    public boolean takeBook(Long userId, Long bookId) {
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("Пользователь с ID: " + userId + ", не найден");
        }

        if (!books.containsKey(bookId)) {
            throw new IllegalArgumentException("Книга с ID: " + bookId + ", не найдена");
        }

        for (ArrayList<Long> userBooks : userBorrowedBooks.values()) {
            if (userBooks.contains(bookId)) {
                return false;
            }
        }

        userBorrowedBooks.computeIfAbsent(userId, b -> new ArrayList<>()).add(bookId);
        return true;
    }


    public Boolean returnBook(Long userId, Long bookId) {
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("Пользователь с ID: " + userId + ", не найден");
        } else if (!books.containsKey(bookId)) {
            throw new IllegalArgumentException("Книга с ID: " + bookId + ", не найдена");
        }
        if (userBorrowedBooks.containsKey(userId)) {
            ArrayList<Long> userBooks = userBorrowedBooks.get(userId);
            if (userBooks.contains(bookId)) {
                userBooks.remove(bookId);
                if (userBooks.isEmpty()) {
                    userBorrowedBooks.remove(userId);
                }
                return true;
            }
        }
        return false;
    }
}
