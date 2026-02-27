import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome to the Palindrome Checker Management System\n" +
                "Version:\n" +
                "1.0\n" +
                "System initialized successfully.");
        String input = scn.nextLine();
        boolean isPalindrome = true;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }

}