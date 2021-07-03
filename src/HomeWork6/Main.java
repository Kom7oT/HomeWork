package HomeWork6;

import HomeWork6.Animals.Animal;
import HomeWork6.Animals.Cat;
import HomeWork6.Animals.Dog;

public class Main {
    public static void main(String[] args) {
        Cat cat1= new Cat("Barsik", "red", 4);
        Cat cat2 = new Cat("Murka", "black", 3);
        Dog dog1 = new Dog("Tuzik", "yellow", 6);
        Dog dog2 = new Dog("Sharik", "blue", 8);
        Dog dog3 = new Dog("Polkan", "green", 7);

        dog1.run(18);
        dog2.run(199);
        dog3.run(678);
        dog1.swim(4);
        dog1.swim(160);
        dog1.swim(70);

        cat1.run(150);
        cat2.run(19);
        cat1.swim(14);
        Animal.getCount();
        Dog.getCount();
        Cat.getCount();
    }
}
