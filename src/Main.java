import java.util.Scanner;
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String word = scn.nextLine();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            queue.add(ch);   // Enqueue (FIFO)
            stack.push(ch);  // Push (LIFO)
        }

        boolean isPalindrome = true;

        // Step 3: Compare dequeue vs pop
        while(!queue.isEmpty()) {
            if(queue.remove() != stack.pop()) {
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