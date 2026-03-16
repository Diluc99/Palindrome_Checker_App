import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerapp {

    // ---------------- STACK METHOD ----------------
    public static boolean stackMethod(String input) {

        String normalized = input.toLowerCase().replaceAll("\\s", "");
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop())
                return false;
        }

        return true;
    }

    // ---------------- DEQUE METHOD ----------------
    public static boolean dequeMethod(String input) {

        String normalized = input.toLowerCase().replaceAll("\\s", "");
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast())
                return false;
        }

        return true;
    }

    // ---------------- RECURSIVE METHOD ----------------
    public static boolean recursiveMethod(String str, int left, int right) {

        if (left >= right)
            return true;

        if (str.charAt(left) != str.charAt(right))
            return false;

        return recursiveMethod(str, left + 1, right - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        String normalized = input.toLowerCase().replaceAll("\\s", "");

        // ---------------- STACK TIMING ----------------
        long start1 = System.nanoTime();
        boolean result1 = stackMethod(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // ---------------- DEQUE TIMING ----------------
        long start2 = System.nanoTime();
        boolean result2 = dequeMethod(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // ---------------- RECURSIVE TIMING ----------------
        long start3 = System.nanoTime();
        boolean result3 = recursiveMethod(normalized, 0, normalized.length() - 1);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        // ---------------- RESULTS ----------------
        System.out.println("\n===== RESULTS =====");

        System.out.println("Stack Method: " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Execution Time: " + time1 + " ns");

        System.out.println("\nDeque Method: " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Execution Time: " + time2 + " ns");

        System.out.println("\nRecursive Method: " + (result3 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Execution Time: " + time3 + " ns");

        sc.close();
    }
}