package HomeWork6.Animals;


public class Dog extends Animal {
    private final int maxRun = 500;
    private final int maxSwim = 10;
    private static int count = 0;

    public Dog(String name, String color, int age) {
        super(name, color, age);
        count++;
    }

    @Override
    public void run(int runDistance) {
        if (runDistance <= maxRun)
            System.out.printf("%s пробежал(а) %dм\n", name, runDistance);
        else System.out.printf("Собака не может пробежать больше %dм\n", maxRun);
    }

    @Override
    public void swim(int swimDistance) {
        if (swimDistance <= maxSwim)
            System.out.printf("%s проплыл(а) %dм\n", name, maxSwim);
        else System.out.printf("Собака не может проплыть беольше %dм\n", maxSwim);
    }

    public static void getCount() {
        System.out.printf("Dogs created: %d\n", count);
    }



}
