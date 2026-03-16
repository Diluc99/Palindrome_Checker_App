public class PalindromeCheckerapp {

    public static boolean isPalindrome(String str, int left, int right) {

        // Base case
        if (left >= right)
            return true;

        if (str.charAt(left) != str.charAt(right))
            return false;

        // Recursive call
        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {

        String str = "madam";

        boolean result = isPalindrome(str, 0, str.length() - 1);

        if (result)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}