package com.hdfclife.queue;

import com.hdfclife.exception.QueueEmptyException;
import com.hdfclife.exception.QueueFullException;

public class CircularClaimQueue {

    private String[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularClaimQueue(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(String value) {

        if (isFull()) {
            throw new QueueFullException("Queue is full");
        }

        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public String dequeue() {

        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }

        String value = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        size--;

        return value;
    }

    public String peek() {

        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }

        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public int size() {
        return size;
    }
}