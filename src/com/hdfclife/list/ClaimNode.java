package com.hdfclife.list;

    public class ClaimNode {
        private int amount;
        private ClaimNode next;

        public ClaimNode(int amount) {
            this.amount = amount;
            this.next = null;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public ClaimNode getNext() {
            return next;
        }

        public void setNext(ClaimNode next) {
            this.next = next;
        }
    }
