import java.util.*;

public class program142
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iCnt = 0;

        System.out.println("Enter the number of elements : ");
        int iLength = sobj.nextInt();

        // Brr = (int *) malloc (sizeof(int) * iLength); - C
        // Brr = [] - Python
        int Brr[] = new int[iLength];

        System.out.println("Enter the Elements : ");

        for(iCnt = 0; iCnt < Brr.length; iCnt++)
        {
           Brr[iCnt] = sobj.nextInt();
        }

        System.out.println("Elements of the array are : ");

        for(iCnt = 0; iCnt < Brr.length; iCnt++)
        {
           System.out.println(Brr[iCnt]);
        }

        Brr = null;
        System.gc();
    }
}