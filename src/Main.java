import java.util.Scanner;

public class PalindromeCheckerapp {

    public static boolean isPalindrome(String str, int left, int right) {

        if (left >= right)
            return true;

        if (str.charAt(left) != str.charAt(right))
            return false;

        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Step 1: Normalize string
        String normalized = input.toLowerCase().replaceAll("\\s", "");

        // Step 2: Apply palindrome logic
        boolean result = isPalindrome(normalized, 0, normalized.length() - 1);

        if (result)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}