package com.example.collections;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private Long userId;



    public User(String name, int age, Long userId) {
        this.name = name;
        this.age = age;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, userId);
    }
}
