package ru.geekbrains.homework3.concurrentcounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentCounter {

    private static final int ITERATIONS = 55;

    public static void main(String[] args) throws InterruptedException {
        ConcurrentCounter myCounter = new ConcurrentCounter();
        myCounter.start();
    }

    private void start() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Counter counter1 = new Counter(lock);
        Counter counter2 = new Counter(lock);
        Counter counter3 = new Counter(lock);

        Thread thread1 = new Thread(new ThreadCounter(counter1, counter3, ITERATIONS));
        Thread thread2 = new Thread(new ThreadCounter(counter2, counter3, ITERATIONS));
        Thread thread3 = new Thread(new ThreadCounter(counter3, counter3, ITERATIONS));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Счетчик 1: " + counter1.getValue());
        System.out.println("Счетчик 2: " + counter2.getValue());
        System.out.println("Счетчик 3: " + counter3.getValue());
    }
}