package Day2;

public class LinkedList{
    private static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; this.next = null; }
    }
    private Node head;
    private int size;
    public LinkedList() { head = null; size = 0; }
    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        newNode.next = null;
        Node nextN = head;
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
        Node n = head;
        String s = "[";
        while(n != null){
            s += n.data + " -> ";
            n = n.next;
        }
        return s + "null]";
    }
    // ============================================================
// CHALLENGE 2A: Return true if the list contains a cycle.
// Use Floyd's Tortoise and Hare algorithm (two pointers).
// ============================================================
    public boolean hasCycle() {
// TODO: implement
        return false;
    }
    // ============================================================
// CHALLENGE 2B: Return the data stored in the MIDDLE node.
// If the list has an even number of nodes, return the
// second of the two middle nodes.
// Do this in ONE pass without knowing the size in advance.
// Use two pointers: one moves 1 step, one moves 2 steps.
// ============================================================
    public String findMiddle() {
// TODO: implement
        return null;
    }
    // ============================================================
// CHALLENGE 2C (BONUS): If a cycle exists, return the node
// data where the cycle begins. Return null if no cycle.
// ============================================================
    public String findCycleStart() {
// TODO: implement
        return null;
    }
    // Helper: creates a cycle for testing purposes only
// (connects the last node back to the node at cycleIndex)
    public void createCycleForTesting(int cycleIndex) {
        if (head == null) return;
        Node tail = head;
        while (tail.next != null) tail = tail.next;
        Node cycleNode = head;
        for (int i = 0; i < cycleIndex; i++) cycleNode = cycleNode.next;
        tail.next = cycleNode;
    }
    // ============================================================
// TESTS
// ============================================================
    public static void main(String[] args) {
        System.out.println("===== CHALLENGE 2A: CYCLE DETECTION =====");
        LinkedList noCycle = new LinkedList();
        noCycle.addLast("a"); noCycle.addLast("b"); noCycle.addLast("c");
        if (!(!noCycle.hasCycle())) {
            System.out.println("FAIL: list with no cycle should return false");
        } else {
            System.out.println("PASS: no cycle detected in normal list");
        }
        LinkedList withCycle = new LinkedList();
        withCycle.addLast("a"); withCycle.addLast("b");
        withCycle.addLast("c"); withCycle.addLast("d");
        withCycle.createCycleForTesting(1); // tail -> node at index 1 ("b")
        if (!(withCycle.hasCycle())) {
            System.out.println("FAIL: list with cycle should return true");
        } else {
            System.out.println("PASS: cycle detected");
        }
        LinkedList emptyList = new LinkedList();
        if (!(!emptyList.hasCycle())) {
            System.out.println("FAIL: empty list should return false");
        } else {
            System.out.println("PASS: no cycle in empty list");
        }
        System.out.println("\n===== CHALLENGE 2B: FIND MIDDLE =====");
        LinkedList odd = new LinkedList();
        odd.addLast("a"); odd.addLast("b"); odd.addLast("c");
        odd.addLast("d"); odd.addLast("e");
        if (!("c".equals(odd.findMiddle()))) {
            System.out.println("FAIL: middle of 5-node list should be 'c', got: " +
                    odd.findMiddle());
        } else {
            System.out.println("PASS: middle of [a,b,c,d,e] is 'c'");
        }
        LinkedList even = new LinkedList();
        even.addLast("a"); even.addLast("b"); even.addLast("c"); even.addLast("d");
        if (!("c".equals(even.findMiddle()))) {
            System.out.println("FAIL: middle of 4-node list should be 'c' (second middle), got: " + even.findMiddle());
        } else {
            System.out.println("PASS: middle of [a,b,c,d] is 'c' (second middle)");
        }
        LinkedList one = new LinkedList();
        one.addLast("x");
        if (!("x".equals(one.findMiddle()))) {
            System.out.println("FAIL: middle of single-node list should be 'x'");
        } else {
            System.out.println("PASS: middle of single-node list is 'x'");
        }
        System.out.println("\n===== CHALLENGE 2C (BONUS): FIND CYCLE START =====");
        LinkedList cs = new LinkedList();
        cs.addLast("0"); cs.addLast("1"); cs.addLast("2");
        cs.addLast("3"); cs.addLast("4");
        cs.createCycleForTesting(2); // cycle starts at index 2 ("2")
        if (!("2".equals(cs.findCycleStart()))) {
            System.out.println("FAIL: cycle start should be '2', got: " +
                    cs.findCycleStart());
        } else {
            System.out.println("PASS: cycle start correctly identified as '2'");
        }
        LinkedList ncs = new LinkedList();
        ncs.addLast("a"); ncs.addLast("b");
        if (!(ncs.findCycleStart() == null)) {
            System.out.println("FAIL: no cycle, should return null");
        } else {
            System.out.println("PASS: no cycle start returns null");
        }
        System.out.println("\nAll Day 2 tests passed!");
    }
}
