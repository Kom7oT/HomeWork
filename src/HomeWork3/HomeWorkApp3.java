package HomeWork3;

import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp3 {
    static Random random = new Random();

    public static void main(String[] args) {
        replaceDigits();
        fillArray(100);
        changeArray();
        fillDiagonal(5);
        System.out.println(Arrays.toString(fillValues(5, 4)));
        findMinMax(6);
        System.out.println(checkBalanceArr(7));
    }

    /**
     * Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия
     * заменить 0 на 1, 1 на 0
     **/
    public static void replaceDigits() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Начальный массив:");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else arr[i] = 0;
        }
        System.out.println("Измененный массив:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Задать пустой целочисленный массив длиной 100.
     * С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100
     **/
    public static void fillArray(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     * пройти по нему циклом, и числа меньшие 6 умножить на 2
     **/
    public static void changeArray() {
        int arr[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Начальный массив:");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("Измененный массив:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Создать квадратный двумерный целочисленный массив
     * (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
     * заполнить его диагональные элементы единицами
     **/
    public static void fillDiagonal(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    arr[i][j] = 1;
                }
                System.out.printf("%5s", arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Написать метод, принимающий на вход два аргумента: len и initialValue,
     * и возвращающий одномерный массив типа int длиной len, каждая ячейка
     * которого равна initialValue
     **/
    public static int[] fillValues(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    /**
     * Задать одномерный массив и найти в нем минимальный и максимальный элементы
     **/
    public static void findMinMax(int n) {
        int[] arr = new int[n];
        int min;
        int max;
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(30) - 16;
        }
        min = arr[0];
        max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.printf("min = %d, max = %d\n", min, max);
    }

    /**
     * Написать метод, в который передается не пустой
     * одномерный целочисленный массив, метод должен
     * вернуть true, если в массиве есть место, в котором
     * сумма левой и правой части массива равны
     **/
    public static boolean checkBalanceArr(int n) {
        int[] arr = new int[n];
        int sum = 0;
        int rightsum = 0;
        boolean balanceExist = false;
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(20);
            sum += arr[i];
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            rightsum += arr[i];
            if (rightsum == sum - rightsum)
                balanceExist = true;
        }
        return balanceExist;
    }
}
