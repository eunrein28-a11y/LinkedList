package Day3;

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
        CircularQueue circle = new CircularQueue(n);
        LinkedList queue = circle.queue;

    }

    private static class CircularQueue{
        public LinkedList queue;
        public CircularQueue(int n){
            queue = new LinkedList();
            for(int i = 0; i < n; i++){
                queue.addLast("" + i);
            }
            Josephus.Node next = queue.head;
            while(next.next != null){
                next = next.next;
            }
            next.next = queue.head;
        }
    }
    private static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; this.next = null; }
    }
    private static class LinkedList{ //Copied from LinkedList Day 2
        private Josephus.Node head;
        private int size;
        public LinkedList() { head = null; size = 0; }
        public void addFirst(String data) {
            Josephus.Node newNode = new Josephus.Node(data);
            newNode.next = head;
            head = newNode;
            size++;
        }
        public void addLast(String data) {
            Josephus.Node newNode = new Josephus.Node(data);
            if(head == null){
                head = newNode;
                size++;
                return;
            }
            newNode.next = null;
            Josephus.Node nextN = head;
            while(nextN.next != null){
                nextN = nextN.next;
            }
            nextN.next = newNode;
            size++;
        }
        public String removeFirst() {
            if(head == null){
                return null;
            }
            String data = head.data;
            head = head.next;
            size--;
            return data;
        }
        public int size() {
            return size;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public String toString() {
            Josephus.Node n = head;
            String s = "[";
            while(n != null){
                s += n.data + " -> ";
                n = n.next;
            }
            return s + "null]";
        }
    }
}
