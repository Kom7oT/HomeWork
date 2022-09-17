package ru.geekbrains.homework1.codeReview;

// класс Engine не реализован

abstract class Car {

    //нарушен принцип инкапсуляции, необходимо сделать поле engine приватным
    private Engine engine;
    private String color;
    private String name;

    // ограничение области видимости метода(protected) - необходимо исправить на public
    public void start() {
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

