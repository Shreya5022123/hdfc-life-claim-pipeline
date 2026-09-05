package com.hdfclife.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

    public static void runDemo() {

        BlockingQueue<Integer> queue =
                new LinkedBlockingQueue<>(4);

        Thread producer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                try {
                    queue.put(i);
                    System.out.println(
                            "Produced: " + i
                    );

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

        }, "Producer");

        Thread consumer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                try {
                    Integer value = queue.take();

                    System.out.println(
                            "Consumed: " + value
                    );

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

        }, "Consumer");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}