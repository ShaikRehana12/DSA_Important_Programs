import java.util.*;

public class Anagram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        if(s1.length() != s2.length()) {
            System.out.println("NO");
            return;
        }

        int[] freq = new int[26];

        // Count characters of first string
        for(char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Remove characters of second string
        for(char ch : s2.toCharArray()) {
            freq[ch - 'a']--;
        }

        // Check frequencies
        for(int x : freq) {
            if(x != 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
 
