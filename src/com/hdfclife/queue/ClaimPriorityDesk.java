package com.hdfclife.queue;

import com.hdfclife.model.Claim;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClaimPriorityDesk {

    private PriorityQueue<Claim> priorityQueue;

    public ClaimPriorityDesk() {

        Comparator<Claim> claimComparator = (c1, c2) -> {

            int urgencyComparison =
                    c1.getUrgency().compareTo(c2.getUrgency());

            if (urgencyComparison != 0) {
                return urgencyComparison;
            }

            return Integer.compare(
                    c2.getAmount(),
                    c1.getAmount()
            );
        };

        priorityQueue = new PriorityQueue<>(claimComparator);
    }

    public void addClaim(Claim claim) {
        priorityQueue.offer(claim);
    }

    public Claim processNext() {
        return priorityQueue.poll();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }
}