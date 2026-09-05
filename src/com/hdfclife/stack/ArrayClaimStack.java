package com.hdfclife.stack;

import com.hdfclife.exception.StackEmptyException;
import com.hdfclife.exception.StackFullException;

public class ArrayClaimStack implements ClaimStack{
    private int[] stack;
    private int top;

    public ArrayClaimStack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }

        int value = stack[top];
        top--;

        return value;
    }

    @Override
    public void push(int value) {
        if (isFull()) {
            throw new StackFullException("Stack is full");
        }

        top++;
        stack[top] = value;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }

        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == stack.length - 1;
    }
}
