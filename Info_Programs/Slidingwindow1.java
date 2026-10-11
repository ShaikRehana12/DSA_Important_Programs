import java.util.*;
public class Slidingwindow1
{
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i =0; i <n; i++)
        {
            a[i] = sc.nextInt();
        }
        Deque<Integer> d  = new ArrayDeque<>();
        for(int i = 0; i <n ; i++)
        {
            while(!d.isEmpty() && d.peekFirst() <= i - k)
            {
                d.pollFirst();
            }
            while(!d.isEmpty() && a[d.peekLast()] <= a[i])
            {
                d.pollLast();
            }
            d.addLast(i);
            if(i >= k - 1)
            {
                System.out.print(a[d.peekFirst()] +" ");
            }
        }
    }
}