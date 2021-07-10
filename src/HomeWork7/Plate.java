package HomeWork7;

public class Plate {
    int food;

    public Plate(int food) {
        this.food = food;
    }

    public void increaseFood(int foodInc) {
        food += foodInc;
        System.out.println("Тарелка пополнена на " + foodInc);
    }

    public void decreaseFood(int foodDec) {
        food -= foodDec;
    }

    public void info() {
        System.out.println("В тарелке осталось " + food + " еды");
    }
}
