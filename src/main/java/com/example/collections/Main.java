package com.example.collections;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();

        libraryService.addBook(1L, new Book("The Infernal Devices", "Kassandra Clare", 2010, 1L));
        libraryService.addBook(2L, new Book("Часовой ключ", "Наталья Щерба", 2011, 2L));
        libraryService.addBook(3L, new Book("Зерцалия", "Евгений Гаглоев", 2018, 3L));
        libraryService.addBook(4L, new Book("Mara and Morok", "Leah Arden", 2020, 4L));
        libraryService.addBook(5L, new Book("The Subtle Art of Not Giving a F*ck", "Mark Manson", 2016, 5L));

        libraryService.addUser(1L, new User("William", 17, 1L));
        libraryService.addUser(2L, new User("Charlotte", 23, 2L));
        libraryService.addUser(3L, new User("James", 17, 3L));
        libraryService.addUser(4L, new User("Henry", 23, 4L));
        libraryService.addUser(5L, new User("Tessa", 16, 5L));

        libraryService.takeBook(1L, 3L);
        libraryService.takeBook(1L, 4L);

        System.out.println(libraryService.getUserBooks(1L));
    }
}
