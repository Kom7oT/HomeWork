package ru.geekbrains.homework1;

public class Main {
    public static void main(String[] args) {
        Person.createBuilder()
                .addFirstName("John")
                .addLastName("Lopez")
                .addAge(32)
                .addGender("Male")
                .addCountry("Mexico");
    }
}
