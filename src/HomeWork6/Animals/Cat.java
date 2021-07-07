package HomeWork6.Animals;


public class Cat extends Animal {
    private final int maxRun = 200;
    private static int count = 0;

    public Cat(String name, String color, int age) {
        super(name, color, age);
        count++;
    }

    @Override
    public void run(int distanceRun) {
        if (distanceRun <= maxRun)
            System.out.printf("%s пробежал(а) %dм\n", name, distanceRun);
        else System.out.printf("Коты не могут пробежать больше %dм\n", maxRun);
    }

    @Override
    public void swim(int swimDistance) {
        System.out.println("Коты не умеют плавать");
    }

    public static void getCount() {
        System.out.printf("Cats created: %d\n", count);
    }

public class Cat {

}
