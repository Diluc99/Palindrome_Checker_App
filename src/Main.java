class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class CharLinkedList {

    Node head;

    // add at end
    public void addLast(char data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // print list (for verification)
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // reverse linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // check palindrome (INTERVIEW OPTIMAL)
    public boolean isPalindrome() {

        if (head == null || head.next == null)
            return true;

        // STEP 1 → find middle (slow fast)
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2 → reverse second half
        Node secondHalfStart = reverse(slow.next);

        // STEP 3 → compare halves
        Node firstHalf = head;
        Node secondHalf = secondHalfStart;

        boolean palindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // STEP 4 → restore list
        slow.next = reverse(secondHalfStart);

        return palindrome;
    }
}

public class Main {

    public static void main(String[] args) {

        String str = "madam";

        CharLinkedList list = new CharLinkedList();

        for (int i = 0; i < str.length(); i++) {
            list.addLast(str.charAt(i));
        }

        System.out.print("Linked List: ");
        list.printList();

        if (list.isPalindrome())
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        System.out.print("List After Check (Restored): ");
        list.printList();
    }
}