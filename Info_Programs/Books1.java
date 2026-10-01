import java.util.*;
public class Books1
{
    static boolean canAllocate(long[] pages, int students, long limit)
    {
        int used = 1;
        long current = 0;
        for(long book : pages)
        {
            if(current + book > limit)
            {
                used++;
                current = book;
                if(used > students)
                {
                    return false;
                }
            }
            else{
                current = current + book;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int students = sc.nextInt();
        long[] pages = new long[n];
        long low = 0;
        long high =0;
        for(int i = 0; i < n; i++)
        {
            pages[i] = sc.nextLong();
            low = Math.max(low, pages[i]);
            high = high + pages[i];
        }
        if(students > n)
        {
            System.out.println(-1);
            return;
        }
        while(low < high)
        {
            long mid = low + (high - low ) / 2;
            if(canAllocate(pages, students,mid))
            {
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}