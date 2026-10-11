import java.util.*;

public class Containsduplicate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {

            int x = sc.nextInt();

            /*
             * If number already exists
             * duplicate found
             */
            if(set.contains(x)) {
                System.out.println("YES");
                return;
            }

            set.add(x);
        }

        System.out.println("NO");
    }
}