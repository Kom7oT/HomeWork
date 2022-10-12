package ru.geekbrains.homework2.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedListImpl<E> implements CustomLinkedList<E> {
    protected int size;
    protected Node<E> firstElement;
    protected Node<E> lastElement;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public void insert(E value, int index) {
        for (int i = 0; i < index; i++) {

        }
        Node<E> newNode = new Node<>(value, firstElement, null);
        if (isEmpty()) {
            lastElement = newNode;
        } else {
            firstElement.previous = newNode;
        }
        firstElement = newNode;
        size++;
    }

    @Override
    public void insertHead(E value) {
        Node<E> newNode = new Node<>(value, firstElement, null);
        if (isEmpty()) {
            lastElement = newNode;
        } else {
            firstElement.previous = newNode;
        }
        firstElement = newNode;
        size++;
    }

    @Override
    public void insertTail(E value) {
        Node<E> newNode = new Node<>(value, null, lastElement);
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
        size++;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }

            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (size == 1) {
            removeHead();
            return true;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
            firstElement.previous = null;
        } else if (current == lastElement) {
            lastElement = current.previous;
            lastElement.next = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        current.next = null;
        current.previous = null;
        current = null; // избыточное зануление? GC должен убрать
        size--;
        return true;
    }

    @Override
    public E removeByIndex(int index) {
        if (isEmpty()) {
            throw new UnsupportedOperationException("The DoublyLinkedList is empty.");
        }

        if (index < 0 || index+1 > size) {
            throw new IndexOutOfBoundsException("No such index in the list.");
        }
        Node<E> removedNode = null;
        if (index < (size / 2)) {
            removedNode = firstElement;
            for (int i = 1; i < index; i++) {
                removedNode = removedNode.next;
            }
        } else {
            removedNode = lastElement;
            for (int i = size; i > index; i--) {
                removedNode = removedNode.previous;
            }
        }

        removedNode.next.previous = removedNode.previous;
        removedNode.previous.next = removedNode.next;
        removedNode.next = null;
        removedNode.previous = null;
        size--;
        return removedNode.value;
    }

    @Override
    public E removeHead() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("The DoublyLinkedList is empty.");
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        firstElement.previous = null;
        removedNode.next = null;
        size--;
        return removedNode.value;
    }

    @Override
    public E removeTail() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("The DoublyLinkedList is empty.");
        }

        Node<E> removedNode = lastElement;
        lastElement = removedNode.previous;
        lastElement.next = null;
        removedNode.previous = null;
        size--;
        return removedNode.value;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index+1 > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = firstElement;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public E getFirst() {
        return firstElement != null ? firstElement.value : null;
    }

    @Override
    public E getLast() {
        return lastElement != null ? lastElement.value : null;
    }

    @Override
    public Iterator iterator() {
        Iterator<E> itr = new Iterator<E>() {

            private final CustomLinkedListImpl<E> list = CustomLinkedListImpl.this;
            private Node<E> current;
            private Node<E> previous;

            {
                reset();
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                E nextValue = current.value;
                previous = current;
                current = current.next;
                return nextValue;
            }

            // удаление элементов во время итерации
            @Override
            public void remove() {
                if (previous == null) {
                    list.firstElement = current.next;
                    reset();
                } else {
                    previous.next = current.next;
                    current.next.previous = previous;
                    if (hasNext()) {
                        current = current.next;
                    } else {
                        reset();
                    }
                }
            }

            public void reset() {
                current = list.firstElement;
                previous = null;
            }
        };

        return itr;
    }


    @Override
    public void printList() {
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}