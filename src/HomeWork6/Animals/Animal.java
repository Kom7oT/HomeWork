package HomeWork6.Animals;


public abstract class Animal {
    String name;
    String color;
    int age;
    private static int count = 0;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        count++;
    }

    public abstract void run(int runDistance);

    public abstract void swim(int swimDistance);

    public static void getCount() {
        System.out.printf("Animals created: %d\n", count);;
    }



}
