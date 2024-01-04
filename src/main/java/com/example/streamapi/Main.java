package com.example.streamapi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Product bookProduct1 = new Product(1L, "Iron Flame", "Books", new BigDecimal("19.16"));
        Product bookProduct2 = new Product(2L, "Oath and Honor", "Books", new BigDecimal("121.52"));
        Product bookProduct3 = new Product(3L, "Haunting Adeline", "Books", new BigDecimal("314.17"));

        Product childrenProduct1 = new Product(4L, "Shampoo", "Children's products", new BigDecimal("5.99"));
        Product childrenProduct2 = new Product(5L, "Cream", "Children's products", new BigDecimal("8.99"));
        Product childrenProduct3 = new Product(6L, "Dry mixture", "Children's products", new BigDecimal("11.99"));

        Product toysProduct1 = new Product(7L, "Spider-Man", "Toys", new BigDecimal("110.15"));
        Product toysProduct2 = new Product(8L, "Rick and Morty", "Toys", new BigDecimal("177.77"));
        Product toysProduct3 = new Product(9L, "Omni-Man", "Toys", new BigDecimal("225.99"));


        Set<Product> orderBooks = new HashSet<>(Arrays.asList(bookProduct1, bookProduct2, bookProduct3));
        Set<Product> orderChildrenProduct = new HashSet<>(Arrays.asList(childrenProduct1, childrenProduct2, childrenProduct3));
        Set<Product> orderToys = new HashSet<>(Arrays.asList(toysProduct1, toysProduct2, toysProduct3));
        Set<Product> orderSundry1 = new HashSet<>(Arrays.asList(toysProduct1, childrenProduct3, bookProduct2));
        Set<Product> orderSundry2 = new HashSet<>(Arrays.asList(childrenProduct1, bookProduct1, toysProduct2));
        Set<Product> orderSundry3 = new HashSet<>(Arrays.asList(bookProduct3, toysProduct3, childrenProduct2));

        Order order1 = new Order(1L, LocalDate.of(2021, 1, 5), LocalDate.of(2021, 1, 7), "reserved", orderBooks);
        Order order2 = new Order(2L, LocalDate.of(2021, 1, 10), LocalDate.of(2021, 1, 12), "on delivery", orderChildrenProduct);
        Order order3 = new Order(3L, LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 15), "delivered", orderToys);
        Order order4 = new Order(4L, LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 21), "reserved", orderSundry1);
        Order order5 = new Order(5L, LocalDate.of(2021, 3, 9), LocalDate.of(2021, 3, 11), "delivered", orderSundry2);
        Order order6 = new Order(6L, LocalDate.of(2021, 3, 24), LocalDate.of(2021, 3, 25), "reserved", orderSundry3);
        Order order7 = new Order(7L, LocalDate.of(2021, 4, 13), LocalDate.of(2021, 4, 13), "delivered", orderToys);
        Order order8 = new Order(8L, LocalDate.of(2021, 4, 29), LocalDate.of(2021, 4, 30), "on delivered", orderSundry2);
        Order order9 = new Order(9L, LocalDate.of(2021, 5, 1), LocalDate.of(2021, 5, 2), "delivered", orderSundry1);
        Order order10 = new Order(10L, LocalDate.of(2021, 5, 11), LocalDate.of(2021, 5, 15), "on delivered", orderBooks);


        List<Customer> customers = new ArrayList<>(Arrays.asList(
                new Customer(1L, "William", 1L, Set.of(order1, order2, order3, order4, order5)),
                new Customer(2L, "James", 1L, Set.of(order10, order5, order3, order4, order6)),
                new Customer(3L, "Henry", 2L, Set.of(order2, order7, order3, order8, order5)),
                new Customer(4L, "Tessa", 2L, Set.of(order3, order2, order5, order4, order8)),
                new Customer(5L, "Dina", 3L, Set.of(order4, order1, order3, order9, order10))
        ));


        // Задание 1
        List<Product> task1 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> "Books".equals(product.getCategory()) && product.getPrice().compareTo(BigDecimal.valueOf(100)) > 0)
                .distinct()
                .toList();

        // Задание 2
        List<Order> task2 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "Children's products".equals(product.getCategory())))
                .distinct()
                .toList();

        // Задание 3
        double task3 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> "Toys".equals(product.getCategory()))
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(0.9)))
                .mapToDouble(BigDecimal::doubleValue)
                .sum();

        // Задание 4
        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

        List<Product> task4 = customers.stream()
                .filter(customer -> customer.getLevel() == 2)
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order ->
                        !order.getOrderDate().isBefore(startDate) && !order.getOrderDate().isAfter(endDate))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .toList();

        // Задание 5
        List<Product> task5 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> "Books".equals(product.getCategory()))
                .distinct()
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(2)
                .toList();

    }
}
