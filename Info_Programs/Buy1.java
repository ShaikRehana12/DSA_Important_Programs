import java.util.*;
public class Buy1
{
    public static void main(String ar[])
    {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        long cash = 0;
        long fee = sc.nextLong();
        long holdEven = Long.MIN_VALUE/ 4;
        long holdOdd  = Long.MIN_VALUE / 4;
        for(int i =0; i< n ; i++)
        {
            long price = sc.nextLong();
            long oldCash = cash;
            long oldEven = holdEven;
            long oldOdd = holdOdd;
            if((price & 1) == 0)
            {
                holdEven = Math.max(oldEven, oldCash - price);
                cash  = Math.max(oldCash,oldOdd + price - fee);
            }
        }
      System.out.println(cash);
    }
}