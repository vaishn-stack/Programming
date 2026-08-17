import java.util.HashMap;
import java.util.Scanner;

public class program771
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        char Arr[] = str.toCharArray();

        int i = 0;

        for (i = 0; i < Arr.length; i++) 
        {
            System.out.println(Arr[i]);
        }

        sobj.close();
    }
}
