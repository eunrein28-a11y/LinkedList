package Day3;

// ============================================================
// DAY 3 STARTER CODE — Circular Linked List Queue
// Name:
// Date:
// ============================================================
public class CircularQueue {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }
    // 'last' points to the last node; last.next is the front
    private Node last;
    private int size;
    public CircularQueue() {
        last = null;
        size = 0;
    }
    // Add to the back of the queue
    public void enqueue(int data) {
// TODO: implement
    }
    // Remove and return from the front of the queue
    public int dequeue() {
// TODO: implement
        return -1;
    }
    // Return the front value without removing it
    public int peek() {
// TODO: implement
        return -1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    // ============================================================
// TESTS
// ============================================================
    public static void main(String[] args) {
        System.out.println("===== CIRCULAR QUEUE TESTS =====");
        CircularQueue q = new CircularQueue();
        if (!(q.isEmpty())) {
            System.out.println("FAIL: new queue should be empty");
        }
        if (!(q.size() == 0)) {
            System.out.println("FAIL: new queue size should be 0");
        } else {
            System.out.println("PASS: new queue is empty");
        }
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        if (!(q.size() == 3)) {
            System.out.println("FAIL: size should be 3");
        }
        if (!(q.peek() == 1)) {
            System.out.println("FAIL: peek should return 1, got: " +
                    q.peek());
        } else {
            System.out.println("PASS: enqueue and peek");
        }
        int d1 = q.dequeue();
        if (!(d1 == 1)) {
            System.out.println("FAIL: dequeue should return 1, got: " +
                    d1);
        }
        if (!(q.size() == 2)) {
            System.out.println("FAIL: size should be 2 after dequeue");
        } else {
            System.out.println("PASS: dequeue returns front element");
        }
        int d2 = q.dequeue();
        int d3 = q.dequeue();
        if (!(d2 == 2 && d3 == 3)) {
            System.out.println("FAIL: FIFO order wrong");
        }
        if (!(q.isEmpty())) {
            System.out.println("FAIL: queue should be empty after all dequeues");
        } else {
            System.out.println("PASS: FIFO order maintained, queue empty after all dequeues");
        }
        q.enqueue(10); q.enqueue(20);
        q.dequeue();
        q.enqueue(30);
        if (!(q.peek() == 20)) {
            System.out.println("FAIL: after dequeue and enqueue, front should be 20");
        } else {
            System.out.println("PASS: circular behavior correct after interleaved enqueue/dequeue");
        }
        System.out.println("\nAll CircularQueue tests passed!");
    }
}
