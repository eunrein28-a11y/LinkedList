package Day3;

// ============================================================
// DAY 3 — Josephus Problem Client
// Name:
// Date:
//
// THIS IS INDIVIDUAL WORK. DO NOT GET HELP FROM ANY OTHER SOURCE.
//
// SOLUTION OUTPUT:
// (Paste your output for: java Josephus 3 41 here before submitting)
//
// ============================================================

public class Josephus {
    public static void main(String[] args) {
        //Read m (skip every m-th) and n (number of people) from command line
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        //TODO: Use your CircularQueue to solve the Josephus problem.
        //Steps to think about:
        //1. Enqueue all people numbered 0 to n-1 into the queue
        //2. Repeatedly rotate the queue (dequeue and re-enqueue) m-1 times, then dequeue and print the eliminated person
        //3. Repeat until the queue is empty
        CircularQueue queue = new CircularQueue();
        for(int i = 0; i < n; i++){
            queue.enqueue(i);
        }

        while (!queue.isEmpty()){
            for(int i = 0; i < m - 1; i++){
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }
}
