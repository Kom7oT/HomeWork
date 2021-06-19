package HomeWork2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(checkSum(15, 14));
        checkNumberIs(-20);
        System.out.println(checkNumber(-10));
        printString("hello, world", 4);
        System.out.println(checkYear(2011));
    }

    /**
     * Написать метод, принимающий на вход два целых числа
     * и проверяющий, что их сумма лежит в пределах от 10 до 20
     * (включительно), если да – вернуть true,
     * в противном случае – false
     **/
    public static boolean checkSum(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    /**
     * Написать метод, которому в качестве параметра
     * передается целое число, метод должен напечатать
     * в консоль, положительное ли число передали или
     * отрицательное. Замечание: ноль считаем
     * положительным числом
     **/
    public static void checkNumberIs(int a) {
        System.out.println(a);
        if (a >= 0) {
            System.out.println("Число положительное");
        } else System.out.println("Число отрицательное");
    }

    /**
     * Написать метод, которому в качестве параметра
     * передается целое число. Метод должен вернуть
     * true, если число отрицательное, и вернуть
     * false если положительное
     **/
    public static boolean checkNumber(int a) {
        return a < 0;
    }

    /**
     * Написать метод, которому в качестве аргументов
     * передается строка и число, метод должен отпечатать
     * в консоль указанную строку, указанное количество раз
     */
    public static void printString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(s);
        }
    }
    /**
     * Написать метод, который определяет, является ли год
     * високосным, и возвращает boolean (високосный - true,
     * не високосный - false). Каждый 4-й год является високосным,
     * кроме каждого 100-го, при этом каждый 400-й – високосный
     **/
    public static boolean checkYear(int a) {
        return a % 4 == 0 && a % 100 != 0 || a % 400 == 0;
    }
}
