import java.util.*;
class Two
{
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
     
        for(int i =0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }
          int target = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < n ;i++)
        {
             int need = target - a[i];
            if(map.containsKey(need))
            {
                System.out.println(map.get(need) + " " +i);
                return;
            }
            map.put(a[i],i);
        }
    }
}