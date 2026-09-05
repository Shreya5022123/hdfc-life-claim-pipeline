package com.hdfclife;

import com.hdfclife.list.*;
import com.hdfclife.model.Claim;
import com.hdfclife.model.Urgency;
import com.hdfclife.queue.BranchBfs;
import com.hdfclife.queue.CircularClaimQueue;
import com.hdfclife.queue.ClaimPriorityDesk;
import com.hdfclife.stack.*;
import com.hdfclife.thread.*;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    static void main(String[] args) {
        ClaimLinkedList list = new ClaimLinkedList();
        list.addLast(25000);
        list.addLast(18000);
        list.addLast(42000);
        list.addLast(15000);
        list.addLast(31000);
        list.addLast(9000);
        System.out.println(list.size());

        System.out.println(Arrays.toString(list.toArray()));
        list.insertAt(2, 22000);
        System.out.println(Arrays.toString(list.toArray()));
        list.deleteAt(2);
        System.out.println(Arrays.toString(list.toArray()));

        ClaimLinkedList recursiveList = new ClaimLinkedList();

        recursiveList.addLast(25000);
        recursiveList.addLast(18000);
        recursiveList.addLast(42000);
        recursiveList.addLast(15000);
        recursiveList.addLast(31000);
        recursiveList.addLast(9000);

        ListReverser.reverseRecursive(recursiveList);

        System.out.println(Arrays.toString(recursiveList.toArray()));

        ClaimLinkedList middleList=new ClaimLinkedList();
        middleList.addLast(25000);
        middleList.addLast(18000);
        middleList.addLast(42000);
        middleList.addLast(15000);
        middleList.addLast(31000);
        middleList.addLast(9000);

        ClaimNode middle = MiddleFinder.findMiddle(middleList);
        System.out.println("Middle: "+middle.getAmount());

        ClaimLinkedList cycleList = new ClaimLinkedList();

        cycleList.addLast(25000);
        cycleList.addLast(18000);
        cycleList.addLast(42000);
        cycleList.addLast(15000);
        cycleList.addLast(31000);
        cycleList.addLast(9000);

        System.out.println("Has cycle: " + CycleDetector.hasCycle(cycleList));

        ClaimNode first = new ClaimNode(3);
        first.setNext(new ClaimNode(4));
        first.getNext().setNext(new ClaimNode(2));

        ClaimNode last = cycleList.nodeAt(5);
        ClaimNode third = cycleList.nodeAt(2);

        last.setNext(third);

        System.out.println("Has cycle: " + CycleDetector.hasCycle(cycleList));

        ClaimNode second = new ClaimNode(4);
        second.setNext(new ClaimNode(6));
        second.getNext().setNext(new ClaimNode(5));

        ClaimNode result = DigitListAdder.add(first, second);

        ClaimNode current = result;

        while (current != null) {
            System.out.print(current.getAmount() + " ");
            current = current.getNext();
        }


        ArrayClaimStack stack = new ArrayClaimStack(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("\nPeek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());

        LinkedClaimStack linkedStack = new LinkedClaimStack();

        linkedStack.push(10);
        linkedStack.push(20);
        linkedStack.push(30);

        System.out.println("Linked Peek: " + linkedStack.peek());
        System.out.println("Linked Pop: " + linkedStack.pop());
        System.out.println("Linked Pop: " + linkedStack.pop());
        System.out.println("Linked Peek: " + linkedStack.peek());


        ClaimStack bracketStack = new ArrayClaimStack(20);

        System.out.println(
                ParenthesesChecker.isBalanced("({[]})", bracketStack)
        );

        ClaimStack postfixStack = new ArrayClaimStack(20);

        int result1 = PostfixEvaluator.evaluate(
                "2 3 + 4 *",
                postfixStack
        );

        System.out.println("Postfix result: " + result1);


        CircularClaimQueue queue = new CircularClaimQueue(4);

        queue.enqueue("CLM-01");
        queue.enqueue("CLM-02");
        queue.enqueue("CLM-03");
        queue.enqueue("CLM-04");

        System.out.println("Peek: " + queue.peek());

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        queue.enqueue("CLM-05");
        queue.enqueue("CLM-06");

        System.out.println("Peek: " + queue.peek());
        System.out.println("Size: " + queue.size());


        String[][] branches = {
                {"Mumbai", "Thane"},
                {"Mumbai", "Navi Mumbai"},
                {"Thane", "Kalwa"},
                {"Thane", "Dombivli"}
        };

        BranchBfs.bfs(branches);


        ClaimPriorityDesk desk = new ClaimPriorityDesk();

        desk.addClaim(new Claim(
                "CLM-01", 25000, "HDFC-LIFE-1001",
                "Anita Sharma", Urgency.HIGH
        ));

        desk.addClaim(new Claim(
                "CLM-02", 18000, "HDFC-LIFE-1002",
                "Rahul Mehta", Urgency.MEDIUM
        ));

        desk.addClaim(new Claim(
                "CLM-03", 42000, "HDFC-LIFE-1005",
                "Sneha Patel", Urgency.HIGH
        ));

        desk.addClaim(new Claim(
                "CLM-04", 15000, "HDFC-LIFE-1004",
                "Vikram Singh", Urgency.LOW
        ));

        desk.addClaim(new Claim(
                "CLM-05", 31000, "HDFC-LIFE-1001",
                "Anita Sharma", Urgency.MEDIUM
        ));

        desk.addClaim(new Claim(
                "CLM-06", 9000, "HDFC-LIFE-1003",
                "Priya Nair", Urgency.LOW
        ));
        System.out.println("\nPriority Queue:");

        while (!desk.isEmpty()) {
            Claim claim = desk.processNext();
            System.out.println(claim);
        }




        SeedRunnable seedRunnable = new SeedRunnable();

        Thread thread = new Thread(seedRunnable);

        thread.start();

        int[] claimAmounts = {
                25000,
                18000,
                42000,
                15000,
                31000,
                9000
        };

        ClaimTotalCallable task =
                new ClaimTotalCallable(claimAmounts);

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(task);

        try {
            int total = future.get();
            System.out.println("Total claim amount: " + total);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        } catch (ExecutionException e) {
            System.out.println("Task failed: " + e.getMessage());
        }

        executor.shutdown();

        CompletableFuture<Integer> completableFuture =
                CompletableFuture.supplyAsync(() -> {

                    int total = 0;

                    for (int i = 0; i < claimAmounts.length; i++) {
                        total += claimAmounts[i];
                    }

                    return total;
                });

        completableFuture.thenAccept(total ->
                System.out.println("CompletableFuture total: " + total)
        );

        completableFuture.join();



        ExecutorService cancelExecutor =
                Executors.newSingleThreadExecutor();

        SleepingCallable sleepingTask =
                new SleepingCallable();

        Future<Integer> sleepingFuture =
                cancelExecutor.submit(sleepingTask);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted");
        }

        boolean cancelled = sleepingFuture.cancel(true);

        System.out.println("Cancelled: " + cancelled);

        cancelExecutor.shutdown();


        ProducerConsumer.runDemo();
        Thread daemonThread = new Thread(
                new DaemonTask(),
                "Claim-Daemon"
        );

        daemonThread.setDaemon(true);

        System.out.println("Is daemon: " + daemonThread.isDaemon());

        daemonThread.start();


    }

}