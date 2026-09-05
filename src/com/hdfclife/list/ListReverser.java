package com.hdfclife.list;

import com.hdfclife.model.Claim;

public class ListReverser {
    public static void reverseIterative(ClaimLinkedList list) {
        ClaimNode previous = null;
        ClaimNode current = list.getHead();

        while (current != null) {
            ClaimNode next = current.getNext();
            current.setNext(previous);

            previous = current;
            current = next;
        }
        list.setHead(previous);
    }
        public static void reverseRecursive (ClaimLinkedList list){
            ClaimNode newHead = reverseRecursive(list.getHead());
            list.setHead(newHead);
        }

        private static ClaimNode reverseRecursive (ClaimNode current){


            if (current == null || current.getNext() == null) {
                return current;
            }


            ClaimNode newHead = reverseRecursive(current.getNext());

            current.getNext().setNext(current);
            current.setNext(null);

            return newHead;
        }
    }
