import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// Stack-based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        String normalized = input.toLowerCase().replaceAll("\\s", "");
        Stack<Character> stack = new Stack<>();

        // Push characters
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Compare while popping
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        String normalized = input.toLowerCase().replaceAll("\\s", "");
        Deque<Character> deque = new ArrayDeque<>();

        // Add characters
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        // Compare first and last
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Main Application Class
public class PalindromeCheckerapp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        System.out.println("\nChoose Algorithm:");
        System.out.println("1 - Stack Strategy");
        System.out.println("2 - Deque Strategy");

        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.check(input);

        if (result)
            System.out.println("\nResult: Palindrome");
        else
            System.out.println("\nResult: Not Palindrome");

        sc.close();
    }
}