package com.example.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private final HashMap<Long, Book> books;
    private final HashMap<Long, User> users;
    private final HashMap<Long, Boolean> isBookTaken;
    private final HashMap<Long, ArrayList<Book>> userBorrowedBooks;

    public LibraryService() {
        books = new HashMap<>();
        users = new HashMap<>();
        isBookTaken = new HashMap<>();
        userBorrowedBooks = new HashMap<>();

    }


    public ArrayList<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public ArrayList<Book> getAllAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for (Map.Entry<Long, Book> bookEntry : books.entrySet()) {
            if (!isBookTaken.getOrDefault(bookEntry.getKey(), false)) {
                isBookTaken.put(bookEntry.getKey(), false);
                availableBooks.add(bookEntry.getValue());
            }
        }
        return availableBooks;
    }

    public ArrayList<Book> getUserBooks(Long userId) {
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("Пользователь с ID: " + userId + ", не найден");
        }
        return userBorrowedBooks.getOrDefault(userId, new ArrayList<>());
    }

    public boolean takeBook(Long userId, Long bookId) {
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("Пользователь с ID: " + userId + ", не найден");
        }
        if (!books.containsKey(bookId)) {
            throw new IllegalArgumentException("Книга с ID: " + bookId + ", не найдена");
        }

        if (isBookTaken.getOrDefault(bookId, false)) {
            return false;
        }
        userBorrowedBooks.computeIfAbsent(userId, v -> new ArrayList<>()).add(books.get(bookId));
        isBookTaken.put(bookId, true);
        return true;
    }

    public Boolean returnBook(Long userId, Long bookId) {
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("Пользователь с ID: " + userId + ", не найден");
        } else if (!books.containsKey(bookId)) {
            throw new IllegalArgumentException("Книга с ID: " + bookId + ", не найдена");
        }

        ArrayList<Book> borrowedBooks = userBorrowedBooks.get(userId);
        if (borrowedBooks == null || !borrowedBooks.contains(books.get(bookId))) {
            return false;
        }

        borrowedBooks.remove(books.get(bookId));
        isBookTaken.put(bookId, false);
        return true;
    }


    public void addBook(Long id, Book book) {
        books.put(id, book);
    }

    public void addUser(Long id, User user) {
        users.put(id, user);
    }

    public HashMap<Long, Book> getBooks() {
        return books;
    }

    public HashMap<Long, User> getUsers() {
        return users;
    }

    public HashMap<Long, Boolean> getIsBookTaken() {
        return isBookTaken;
    }

    public HashMap<Long, ArrayList<Book>> getUserBorrowedBooks() {
        return userBorrowedBooks;
    }
}
