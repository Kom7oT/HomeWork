package HomeWork6.Animals;

public class Dog extends Animal {
    private int maxRun = 500;
    private int maxSwim = 10;
    private static int count = 0;

    public Dog(String name, String color, int age) {
        super(name, color, age);
        count++;
    }


    @Override
    public void run(int distanceRun) {
        if (distanceRun <= maxRun)
            System.out.printf("%s пробежал: %dм\n", name, distanceRun);
        else System.out.printf("Собака не может пробежать больше %dм\n", maxRun);
    }

    @Override
    public void swim(int distanceSwim) {
        if (distanceSwim <= maxSwim)
            System.out.printf("%s проплыл %dм\n", name, distanceSwim);
        else System.out.printf("Собака не может проплыть больше %dм\n", maxSwim);
    }


    public static void getCount() {
        System.out.printf("Dogs created: %d\n",count);
    }
}
