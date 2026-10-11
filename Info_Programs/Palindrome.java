import java.util.*;

public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        // Convert to lowercase
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {

            // Skip non-alphanumeric characters
            while(left < right &&
                  !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while(left < right &&
                  !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Characters must match
            if(s.charAt(left) != s.charAt(right)) {
                System.out.println("NO");
                return;
            }

            left++;
            right--;
        }

        System.out.println("YES");
    }
}