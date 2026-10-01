import java.util.*;

public class WordBreak {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // Input string
        String x = s.next();

        // Number of dictionary words
        int n = s.nextInt();

        // Store all dictionary words in a HashSet
        // for O(1) lookup
        Set<String> dict = new HashSet<>();

        while (n-- > 0) {
            dict.add(s.next());
        }

        /*
         * DP Array
         *
         * dp[i] = true
         * means the substring x[0...i-1]
         * can be formed using dictionary words
         */
        boolean[] dp = new boolean[x.length() + 1];

        // Empty string is always valid
        dp[0] = true;

        /*
         * Check every prefix ending at position i
         */
        for (int i = 1; i <= x.length(); i++) {

            /*
             * Try every possible split position j
             */
            for (int j = 0; j < i; j++) {

                /*
                 * Conditions:
                 *
                 * 1. Left portion is already valid
                 * 2. Right portion exists in dictionary
                 */
                if (dp[j] &&
                        dict.contains(x.substring(j, i))) {

                    dp[i] = true;

                    // No need to check more splits
                    break;
                }
            }
        }

        /*
         * If entire string can be formed
         * output YES
         */
        System.out.println(dp[x.length()] ? "YES" : "NO");
    }
}