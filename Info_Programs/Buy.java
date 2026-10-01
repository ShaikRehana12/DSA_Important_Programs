import java.util.*;

public class Buy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of days
        int n = sc.nextInt();

        // Transaction fee
        long fee = sc.nextLong();

        // Profit when we do not hold any stock
        long cash = 0;

        // Profit when holding a stock bought at EVEN price
        long holdEven = Long.MIN_VALUE / 4;

        // Profit when holding a stock bought at ODD price
        long holdOdd = Long.MIN_VALUE / 4;

        // Process each day's stock price
        for (int i = 0; i < n; i++) {

            long price = sc.nextLong();

            // Store previous state values
            long oldCash = cash;
            long oldEven = holdEven;
            long oldOdd = holdOdd;

            // Current price is EVEN
            if ((price & 1) == 0)
                 {

                // Buy stock at an even price
                holdEven = Math.max(
                        oldEven,
                        oldCash - price
                );

                // Sell stock bought at an ODD price
                cash = Math.max(
                        oldCash,
                        oldOdd + price - fee
                );
            }
            else {

                // Buy stock at an odd price
                holdOdd = Math.max(
                        oldOdd,
                        oldCash - price
                );

                // Sell stock bought at an EVEN price
                cash = Math.max(
                        oldCash,
                        oldEven + price - fee
                );
            }
        }

        // Maximum achievable profit
        System.out.println(cash);
    }
}