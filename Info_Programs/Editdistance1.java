import java.util.*;
public class Editdistance1
{
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int[] prev = new int[b.length() + 1];
        int[] curr = new int[b.length() + 1];
        for(int j = 0; j <= b.length(); j++)
        {
            prev[j] = j;
        }
        for(int i = 1; i <= a.length(); i++)
        {
            curr[0] = i;
            for(int j = 1; j <=b.length(); j++)
            {
                if(a.charAt(i - 1) == b.charAt(j - 1))
                {
                    curr[j] = prev[j-1];
                }
                else{
                    int insert = curr[j - 1];
                    int delete = prev[j];
                    int replace = prev[j - 1];
                    curr[j] = 1+ Math.min(insert, Math.min(delete, replace));
                }
            }
            int[] temp = prev;
            prev = curr;
            curr =temp;
        }
        System.out.println(prev[b.length()]);
    }
}