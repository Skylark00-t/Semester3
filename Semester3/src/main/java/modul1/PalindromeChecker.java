package modul1;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan kata atau kalimat: ");
        String input = scanner.nextLine();

        String cleanedInput = input.replaceAll("[^a-zA-Z]","").toLowerCase();

        if (isPalindrome(cleanedInput)){
            System.out.println("Ini adalah Palindrome");
        } else {
            System.out.println("Ini bukan Palindrome");
        }
    }
    public static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
