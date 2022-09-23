package ru.geekbrains.homework2.arrayList;

public interface CustomArrayList<E> {

        // Query Operations
        int size();
        boolean isEmpty();
        boolean contains(Object o);
        Object[] toArray();

        // Modification Operations
        boolean add(E value);
        boolean removeValue(Object o);
        void clear();

        void trimCapacity();

        // Positional Access Operations
        E get(int index);
        E set(int index, E value);
        boolean add(int index, E value);
        E remove(int index);

        // Search Operations
        int indexOf(Object o);
}
