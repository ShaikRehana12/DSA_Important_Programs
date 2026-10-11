import java.util.*;

public class Twosum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of elements
        int n = sc.nextInt();

        int[] a = new int[n];

        // Read array
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Target value
        int target = sc.nextInt();

        /*
         * HashMap stores:
         * number -> index
         */
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {

            // Number needed to reach target
            int need = target - a[i];

            // If complement exists
            if(map.containsKey(need)) {

                System.out.println(map.get(need) + " " + i);
                return;
            }

            map.put(a[i], i);
        }
    }
}