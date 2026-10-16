package Day3;

// ============================================================
// DAY 3 — Josephus Problem Client
// Name:
// Date:
//
// THIS IS INDIVIDUAL WORK. DO NOT GET HELP FROM ANY OTHER SOURCE.
//
// SOLUTION OUTPUT: 2 5 8 11 14 17 20 23 26 29 32 35 38 0 4 9 13 18 22 27 31 36 40 6 12 19 25 33 39 7 16 28 37 10 24 1 21 3 34 15 30
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
        CircularQueue circle = new CircularQueue();
        for(int i = 0; i < n; i++){
            circle.enqueue(i);
        }

        while (!circle.isEmpty()){
            for(int i = 0; i < m - 1; i++){
                circle.enqueue(circle.dequeue());
            }
            System.out.print(circle.dequeue() + " ");
        }
        System.out.println();
    }
}
