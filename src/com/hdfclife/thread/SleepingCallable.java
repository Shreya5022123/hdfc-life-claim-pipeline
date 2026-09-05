package com.hdfclife.thread;

import java.util.concurrent.Callable;

public class SleepingCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println("Sleeping task started");

        try {
            Thread.sleep(10000); // sleep for 10 seconds

            System.out.println("Sleeping task completed");

            return 100;

        } catch (InterruptedException e) {

            System.out.println("Sleeping task was interrupted");

            Thread.currentThread().interrupt();

            throw e;
        }
    }
}