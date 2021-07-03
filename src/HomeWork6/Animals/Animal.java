package HomeWork6.Animals;

public abstract class Animal {
   protected String name;
   protected String color;
   protected int age;
   private static int count;


    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        count++;
    }

    public void run(int distanceRun) {
    }

   public void swim(int distanceSwim){

    }
    public static void getCount(){
        System.out.printf("Animals created: %d\n", count);
    }
}
