package ru.geekbrains.homework1;

public class Main {
    public static void main(String[] args) {
        Person person = Person.createBuilder()
                .addFirstName("John")
                .addLastName("Lopez")
                .addAge(32)
                .addGender("Male")
                .addCountry("Mexico")
                .build();
        System.out.println(person);
    }
}
