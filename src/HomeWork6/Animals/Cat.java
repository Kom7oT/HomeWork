package HomeWork6.Animals;

public class Cat extends Animal {
private int maxRun=200;
private int maxSwim=0;
private static int count=0;

    public Cat(String name, String color, int age) {
        super(name, color, age);
        count++;
    }

    @Override
    public void run(int distanceRun) {
        if (distanceRun <= maxRun)
            System.out.printf("%s пробежал: %dм\n",name, distanceRun);
        else System.out.printf("Кот не может пробежать больше %dм\n", maxRun);
    }

    @Override
    public void swim(int distanceSwim) {
        System.out.printf("Коты не умеют плавать!!!\n");
    }

    public static void  getCount(){
        System.out.printf("Cats created: %d\n", count);
    }
}

