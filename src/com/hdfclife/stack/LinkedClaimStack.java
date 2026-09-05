package com.hdfclife.stack;

import com.hdfclife.exception.StackEmptyException;
import com.hdfclife.list.ClaimNode;

public class LinkedClaimStack implements ClaimStack {

    private ClaimNode top;

    public LinkedClaimStack() {
        top = null;
    }

    @Override
    public void push(int value) {
        ClaimNode newNode = new ClaimNode(value);

        newNode.setNext(top);
        top = newNode;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }

        int value = top.getAmount();
        top = top.getNext();

        return value;
    }
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }

        return top.getAmount();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}