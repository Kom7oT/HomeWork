package ru.geekbrains.homework2.arrayList;

import java.util.Arrays;

public class ArrayListImpl<E> implements CustomArrayList<E> {

    protected E arr[];
    protected int size;
    protected int capacity;
    protected int START_CAPACITY = 10;

    public ArrayListImpl() {
        capacity = START_CAPACITY;
        arr = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (arr[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    // из класса Collections
    public <E> E[] toArray(E[] e) {
        if (e.length < size) return (E[]) Arrays.copyOf(arr, size, e.getClass());
        System.arraycopy(arr, 0, e, 0, size);
        if (e.length > size) e[size] = null;
        return e;
    }

    @Override
    public boolean add(E value) {
        return add(size, value);
    }

    @Override
    public boolean add(int index, E value) {
        try {
            checkForAdd(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            return false;
        }
        checkCapacity();
        if (index < size) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        arr[index] = value;
        size++;
        return true;
    }

    private void checkForAdd(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private E[] newCapacity(int capacity) {
        this.capacity = capacity;
        Object[] newArr = new Object[capacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        return (E[]) newArr;
    }

    private void checkCapacity() {
        if (capacity * 3 / 4 < size) {
            arr = newCapacity(capacity / 2 * 3 + 1);
        }
    }

    @Override
    public void trimCapacity() {
        if (size > 0) {
            arr = newCapacity(size);
        } else {
            arr = newCapacity(START_CAPACITY);
        }
    }

    @Override
    public boolean removeValue(Object o) {
        int i = indexOf(o);
        return remove(i).equals(o);
    }

    @Override
    public E remove(int index) {
        checkForAdd(index);
        E removedElement = arr[index];
        final int newSize;
        if ((newSize = size - 1) > index)
            System.arraycopy(arr, index + 1, arr, index, newSize - index);
        arr[size = newSize] = null;
        return removedElement;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        checkForAdd(index);
        return arr[index];
    }

    @Override
    public E set(int index, E value) {
        checkForAdd(index);
        arr[index] = value;
        return arr[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(arr, 0, size));
    }

    public String toStringFullData() {
        return "ArrayListImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}

