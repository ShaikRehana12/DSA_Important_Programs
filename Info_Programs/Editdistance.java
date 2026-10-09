import java.util.*;

public class Editdistance {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // First string
        String a = s.next();

        // Second string
        String b = s.next();

        /*
         * Previous row of DP table
         */
        int[] prev = new int[b.length() + 1];

        /*
         * Current row of DP table
         */
        int[] curr = new int[b.length() + 1];

        /*
         * Base case:
         * Convert empty string to first j characters
         * using j insertions
         */
        for (int j = 0; j <= b.length(); j++) {
            prev[j] = j;
        }

        /*
         * Process every character of string a
         */
        for (int i = 1; i <= a.length(); i++) {

            /*
             * Convert first i characters of a
             * to empty string
             * requires i deletions
             */
            curr[0] = i;

            for (int j = 1; j <= b.length(); j++) {

                // Characters match
                if (a.charAt(i - 1) == b.charAt(j - 1)) {

                    /*
                     * No operation needed
                     */
                    curr[j] = prev[j - 1];
                }
                else {

                    /*
                     * Insert
                     */
                    int insert = curr[j - 1];

                    /*
                     * Delete
                     */
                    int delete = prev[j];

                    /*
                     * Replace
                     */
                    int replace = prev[j - 1];

                    /*
                     * Choose the best operation
                     */
                    curr[j] = 1 + Math.min(
                            insert,
                            Math.min(delete, replace)
                    );
                }
            }

            /*
             * Current row becomes previous row
             * for next iteration
             */
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        /*
         * Final answer
         */
        System.out.println(prev[b.length()]);
    }
} 