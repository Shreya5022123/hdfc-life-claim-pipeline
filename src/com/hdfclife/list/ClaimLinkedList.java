package com.hdfclife.list;

import com.hdfclife.exception.EmptyListException;
import com.hdfclife.exception.InvalidIndexException;
import com.hdfclife.exception.StackEmptyException;

public class ClaimLinkedList {
    private ClaimNode head;
    private int size;


    public ClaimLinkedList() {
        this.head = null;
        this.size = 0;
    }
    public ClaimNode getHead() {
        return head;
    }

    public void setHead(ClaimNode head) {
        this.head = head;
    }
    public void addLast(int amount){
        ClaimNode newNode = new ClaimNode(amount);
        if(size==0){
            head = newNode;

        }
        else{
            ClaimNode current = head;
            while(current.getNext()!=null){
                current = current.getNext();
            }
            current.setNext(newNode);

        }
        size++;

    }
    public void addFirst(int amount){
        ClaimNode newNode=new ClaimNode(amount);
            newNode.setNext(head);
            head=newNode;
        size++;
    }

    public void insertAt(int index, int amount){
        if (index == 0) {
            addFirst(amount);
            return;
        }
        if (index == size) {
            addLast(amount);
            return;
        }
        if (index < 0 || index > size) {
            throw new InvalidIndexException("invalid index.");
        }
            ClaimNode newNode = new ClaimNode(amount);
            ClaimNode current = head;
            int currentIndex = 0;
            while (currentIndex < index-1  ) {

                current = current.getNext();
                currentIndex++;
            }
            ClaimNode nextNode = current.getNext();
            newNode.setNext(nextNode);
            current.setNext(newNode);

            size++;

    }

    public void deleteAt(int index){
        if(size==0){
            throw new EmptyListException("Linked list is empty");
        }
        if (index<0||index>=size){
            throw new InvalidIndexException("invalid index.");
        }

        if (index==0){
            head=head.getNext();
        }
        else{
            ClaimNode current =head;
            int currentIndex=0;
            while(currentIndex <index-1){
                current=current.getNext();
                currentIndex++;
            }
            current.setNext(current.getNext().getNext());
        }

        size--;

    }

    public ClaimNode nodeAt(int index) {
        if(size==0){
            throw new EmptyListException("Linked list is empty");
        }
        if (index<0||index>=size){
            throw new InvalidIndexException("invalid index.");
        }
        ClaimNode current=head;
        int currentIndex=0;
        while (currentIndex<index){
            current=current.getNext();
            currentIndex++;

        }
        return current;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] result = new int[size];
        ClaimNode current = head;
        for(int i=0;i<size;i++){
            result[i]=current.getAmount();
            current=current.getNext();
        }
        return result;
    }
}
