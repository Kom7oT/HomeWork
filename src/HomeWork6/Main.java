package HomeWork6;

import HomeWork6.Animals.Animal;
import HomeWork6.Animals.Cat;
import HomeWork6.Animals.Dog;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", "red", 4);
        Cat cat2 = new Cat("Murka", "brown", 3);
        Dog dog1= new Dog("Tuzik", "black", 7);
        Dog dog2= new Dog("Sharik", "yellow", 9);
        Dog dog3= new Dog("Polkan", "white", 2);

        cat1.run(4);
        cat2.run(320);
        dog1.run(200);
        dog3.run(643);
        cat1.swim(4);
        dog1.swim(10);
        dog3.swim(23);
        Animal.getCount();
        Cat.getCount();
        Dog.getCount();
    }

}
