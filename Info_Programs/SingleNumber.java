import java.util.*;

public class SingleNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = 0;

        for(int i = 0; i < n; i++) {

            int x = sc.nextInt();

            /*
             * XOR properties:
             *
             * a ^ a = 0
             * a ^ 0 = a
             */
            answer ^= x;
        }

        System.out.println(answer);
    }
}