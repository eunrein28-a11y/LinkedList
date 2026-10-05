// ============================================================
// DAY 1 STARTER CODE — Singly Linked List
// Name:
// Date:
// ============================================================
public class LinkedList{
    // ----- Node class (inner) -----
    private static class Node {
        String data;
        Node next;
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    private int size;
    public LinkedList() {
        head = null;
        size = 0;
    }
    // Add a node to the front of the list
    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    // Add a node to the end of the list
    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
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
    // Remove and return the first element
    public String removeFirst() {
        if(head == null){
            return null;
        }
        String data = head.data;
        head = head.next;
        size--;
        return data;
    }
    // Return the number of elements
    public int size() {
        return size;
    }
    // Return true if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }
    // Return a string representation: [a -> b -> c -> null]
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
// CHALLENGE 1A: Reverse the linked list in place
// ============================================================
    public void reverse() {
// TODO: implement
    }
    // ============================================================
// CHALLENGE 1B: Return true if the list reads the same
// forwards and backwards (palindrome check)
// ============================================================
    public boolean isPalindrome() {
// TODO: implement
        return false;
    }
    // ============================================================
// TESTS — run main() to check your implementation
// ============================================================
    public static void main(String[] args) {
        System.out.println("===== BASIC OPERATIONS =====");
        LinkedList list = new LinkedList();
        assert list.isEmpty() : "FAIL: new list should be empty";
        assert list.size() == 0 : "FAIL: new list size should be 0";
        System.out.println("PASS: isEmpty and size on empty list");
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        assert list.size() == 3 : "FAIL: size should be 3";
        assert list.toString().equals("[a -> b -> c -> null]") : "FAIL: toString wrong after addLast. Got: " + list.toString();
        System.out.println("PASS: addLast and toString");
        list.addFirst("z");
        assert list.toString().equals("[z -> a -> b -> c -> null]") :
                "FAIL: toString wrong after addFirst. Got: " + list.toString();
        System.out.println("PASS: addFirst");
        String removed = list.removeFirst();
        assert removed.equals("z") : "FAIL: removeFirst should return 'z', got: " + removed;
        assert list.size() == 3 : "FAIL: size should be 3 after removeFirst";
        System.out.println("PASS: removeFirst");
        System.out.println("\n===== CHALLENGE 1A: REVERSE =====");
        LinkedList rev = new LinkedList();
        rev.addLast("1");
        rev.addLast("2");
        rev.addLast("3");
        rev.reverse();
        assert rev.toString().equals("[3 -> 2 -> 1 -> null]") : "FAIL: reverse wrong. Got: " + rev.toString();
        System.out.println("PASS: reverse [1->2->3] => [3->2->1]");
        LinkedList single = new LinkedList();
        single.addLast("x");
        single.reverse();
        assert single.toString().equals("[x -> null]") : "FAIL: reverse of single element wrong";
        System.out.println("PASS: reverse single element");
        LinkedList empty = new LinkedList();
        empty.reverse();
        assert empty.isEmpty() : "FAIL: reverse of empty list should stay empty";
        System.out.println("PASS: reverse empty list");
        System.out.println("\n===== CHALLENGE 1B: PALINDROME =====");
        LinkedList pal1 = new LinkedList();
        for (char c : "racecar".toCharArray())
            pal1.addLast(String.valueOf(c));
        assert pal1.isPalindrome() : "FAIL: 'racecar' should be a palindrome";
        System.out.println("PASS: 'racecar' is a palindrome");
        LinkedList pal2 = new LinkedList();
        for (char c : "hello".toCharArray())
            pal2.addLast(String.valueOf(c));
        assert !pal2.isPalindrome() : "FAIL: 'hello' should NOT be a palindrome";
        System.out.println("PASS: 'hello' is not a palindrome");
        LinkedList pal3 = new LinkedList();
        for (char c : "a".toCharArray()) pal3.addLast(String.valueOf(c));
        assert pal3.isPalindrome() : "FAIL: single character should be a palindrome";
        System.out.println("PASS: single character is a palindrome");
        LinkedList pal4 = new LinkedList();
        for (char c : "abba".toCharArray())
            pal4.addLast(String.valueOf(c));
        assert pal4.isPalindrome() : "FAIL: 'abba' should be a palindrome";
        System.out.println("PASS: 'abba' is a palindrome");
        System.out.println("\nAll Day 1 tests passed!");
    }
}
