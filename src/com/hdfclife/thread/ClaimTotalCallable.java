package com.hdfclife.thread;

import java.util.concurrent.Callable;

public class ClaimTotalCallable implements Callable<Integer> {

    private int[] claimAmounts;

    public ClaimTotalCallable(int[] claimAmounts) {
        this.claimAmounts = claimAmounts;
    }

    @Override
    public Integer call() {

        int total = 0;

        for (int i = 0; i < claimAmounts.length; i++) {
            total += claimAmounts[i];
        }

        return total;
    }
}