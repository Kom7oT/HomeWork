package ru.geekbrains.homework3.pingpong;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class PingPong {

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        pingPong.start();
    }

    private void start() {
        Thread ping = new Thread(new Word(), "ping");
        ping.start();
        Thread pong = new Thread(new Word(), "pong");
        pong.start();
    }

    protected class Word implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    printWord();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected synchronized void printWord() throws InterruptedException {
        int counter = 1;
        while (!currentThread().isInterrupted() && counter < 10) {
            System.out.println(Thread.currentThread().getName());
            sleep(300);
            notify();
            wait();
            counter++;
        }
        Thread.currentThread().interrupt();
    }
}
