import java.util.Scanner;

// Service class
class PalindromeChecker {

    // Public method exposed
    public boolean checkPalindrome(String input) {

        // Normalize string
        String normalized = input.toLowerCase().replaceAll("\\s", "");

        int n = normalized.length();

        // Internal data structure (array acting as stack)
        char[] stack = new char[n];

        // Push characters into stack
        for (int i = 0; i < n; i++) {
            stack[i] = normalized.charAt(i);
        }

        // Compare original with reverse (pop simulation)
        for (int i = 0; i < n; i++) {
            if (normalized.charAt(i) != stack[n - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}

// Application class
public class PalindromeCheckerapp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Create object of service class
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}