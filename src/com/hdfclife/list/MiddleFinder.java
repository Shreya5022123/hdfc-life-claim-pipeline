package com.hdfclife.list;

public class MiddleFinder {
    public static ClaimNode findMiddle(ClaimLinkedList list){
        ClaimNode slow=list.getHead();
        ClaimNode fast=list.getHead();

        while(fast !=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }
        return slow;

    }
}
