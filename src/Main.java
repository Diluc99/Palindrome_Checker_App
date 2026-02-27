import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String word = scn.nextLine();

        char[] characters = word.toCharArray();


        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        while(start < end) {
            if(characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if(isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }


    }
    }