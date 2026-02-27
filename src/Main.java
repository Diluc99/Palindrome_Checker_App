import java.util.Scanner;
import java.util.Stack;
class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String word = scn.nextLine();


        Stack<Character> stack = new Stack<>();

        // Step 2: Push characters into stack
        for(int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        boolean isPalindrome = true;

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }

    }
}