package com.hdfclife.list;

public class CycleDetector {
    public static boolean hasCycle(ClaimLinkedList list){
        ClaimNode slow=list.getHead();
        ClaimNode fast=list.getHead();
        while(fast!=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
