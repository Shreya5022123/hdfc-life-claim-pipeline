package com.hdfclife.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BranchBfs {

    public static void bfs(String[][] branches) {

        Queue<String> queue = new LinkedList<>();

        queue.add(branches[0][0]);

        while (!queue.isEmpty()) {

            String branch = queue.remove();

            System.out.println(branch);

            for (int i = 0; i < branches.length; i++) {

                if (branches[i][0].equals(branch)) {
                    queue.add(branches[i][1]);
                }
            }
        }
    }
}