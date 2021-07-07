package HomeWork7;

public class Cat {
    String name;
    int appetite;
    boolean fullness = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p){
        p.decreaseFood(appetite);
    }
}
