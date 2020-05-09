package study.thread.ProductorAndConsumer;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        value = 0;
        Object lock = new Object();
        Runnable p1 = () -> {
            Producer producer = new Producer(lock, "p1");
            while (true) {
                producer.produce();
            }
        };


        Runnable p2 = new Runnable() {
            @Override
            public void run() {
                Producer producer = new Producer(lock, "p2");
                while (true) {
                    producer.produce();
                }
            }
        };

        Runnable c1 = new Runnable() {
            @Override
            public void run() {
                Consumer consumer = new Consumer(lock, "c1");
                while (true) {
                    consumer.consume();
                }
            }
        };

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(c1).start();

    }

    static List<Integer> list = new ArrayList<>();

    static int value = 0;
    static final int max = 3;

    static class Producer {

        final Object lock;
        final String name;

        Producer(Object lock, String name) {
            this.lock = lock;
            this.name = name;

        }

        void produce() {

            try {
                synchronized (lock) {

                    while (list.size() == max) {
                        System.out.println("producer " + name + " wait as size is " + list.size());
                        lock.wait();
                    }

                    if (list.size() > 10) {
                        System.out.println("producer " + name + " wait as size is " + list.size());
                        lock.wait();
                    }

                    list.add(value);
                    value++;
                    System.out.println("producer " + name + " add one, cur size is " + list.size());
                    lock.notifyAll();
                    lock.wait(30);
                }

            } catch (Exception e) {

            }

        }

    }

    static class Consumer {

        final Object lock;
        final String name;

        public Consumer(Object lock, String name) {
            this.lock = lock;
            this.name = name;
        }

        void consume() {
            try {
                synchronized (lock) {
                    if (list.size() == 0) {
                        System.out.println("consumer " + name + " wait as size is " + list.size());
                        lock.notifyAll();
                        lock.wait();
                    }

                    Integer value = list.remove(0);
                    System.out.println("consumer " + name + " got value " + value + " list size is : " + list.size());
                    if (value == 20) {
                        System.exit(0);
                    }
                    notifyAll();
                }
            } catch (Exception e) {

            }
        }
    }
}
