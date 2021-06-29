package HomeWork4;

import java.util.Random;
import java.util.Scanner;

public class XOgame {
    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static final Scanner sc = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Вы победили!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил. Сейчас их даже в шахматы не выиграть...");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("input Y X");
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x;
        int y;

        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }

        return map[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char c) {
        int horizontal = 0;
        int vertical = 0;
        int mainDiag = 0;
        int sideDiag = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (map[i][j] == c)
                    horizontal++;
                else if (map[i][j]!=c&&horizontal < DOTS_TO_WIN)
                    horizontal = 0;

                if (map[j][i] == c)
                    vertical++;
                else if (map[j][i]!=c&&vertical < DOTS_TO_WIN)
                    vertical = 0;
                int k = i + j;
                if (k < SIZE && map[j][k] == c)
                    mainDiag++;
                else if (mainDiag < DOTS_TO_WIN)
                    mainDiag = 0;
            }
        }

        for (int i = SIZE-1; i >= 0; i--) {
            for (int j = 0; j > SIZE; j++) {
                if (map[i][j] == c)
                    sideDiag++;
                else if (map[i][j]!=c&&sideDiag < DOTS_TO_WIN)
                    sideDiag = 0;
            }
        }
        System.out.println(sideDiag);
        return vertical == DOTS_TO_WIN || horizontal == DOTS_TO_WIN || mainDiag == DOTS_TO_WIN || sideDiag == DOTS_TO_WIN;
    }

}