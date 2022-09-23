package ru.geekbrains.homework2.linkedList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testLinkedList();

        List<Integer> lll = new ArrayList<>();
//        testForEach();
    }

    private static void testLinkedList() {
        CustomLinkedList<Integer> list = new CustomLinkedListImpl<>();

        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        list.insertHead(4);
        list.insertTail(5);
        list.insertTail(6);
        System.out.println("Исходный список:");
        list.printList(); // ожидаем: 4-3-2-1-5-6
        System.out.println();

        System.out.println("Количество элементов в списке: " + list.size());
        System.out.println("Первый элемент: " + list.getFirst());
        System.out.println("Последний элемент: " + list.getLast());
        System.out.println("Поиск значения '2': " + list.contains(2));
        System.out.println("Поиск значения '100': " + list.contains(4444));
        System.out.println("Значение первого элемента списка: " + list.getFirst());
        System.out.println("Значение последнего элемента списка: " + list.getLast());
        System.out.println("Значение 4-го элемента списка: " + list.get(3)); // индексация от 0 ~> индекс 4-го элемента = 3
        System.out.println();

        System.out.println("Удалить первый элемент списка:");
        list.removeHead();      // удалить 4 в начале списка
        list.printList();       // ожидаем: 3-2-1-5-6

        System.out.println("Удалить элемент со значением '2':");
        list.remove(2);   // удалить 2 в середине списка (по значению)
        list.printList();       // ожидаем: 3-1-5-6

        System.out.println("Удалить элемент с индексом 2:");
        list.removeByIndex(2);   // удалить 2 в середине списка (по значению)
        list.printList();       // ожидаем: 3-1-6

        System.out.println("Удалить последний элемент списка:");
        list.removeTail();      // удалить 6 в конце списка
        list.printList();       // ожидаем: 3-1

        System.out.println();
        System.out.println("Удаление из пустого списка:");
        list = new CustomLinkedListImpl<>();
        try {
            list.removeHead();      // ожидаем exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Удаление первого элемента невозможно, т.к. список пустой!");
        }
        try {
            list.removeTail();      // ожидаем exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Удаление последнего элемента невозможно, т.к. список пустой!");
        }

        System.out.println("Удаление несуществующего элемента, результат: " + list.remove(100)); // ожидаем false

        try {
            list.removeByIndex(4);      // ожидаем exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Удаление заданного элемента невозможно, т.к. список пустой!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Элемента с таким индексом нет в списке!");
        }
    }
}