package com.hdfclife.thread;

public class DaemonTask implements Runnable {

    @Override
    public void run() {

        while (true) {
            System.out.println("Daemon thread running...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}