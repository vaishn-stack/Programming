// import java.util.*;

import java.util.Scanner;

public class program144
{
    public static void Update(int Arr[])
    {
        int iCnt = 0;

        for(iCnt = 0; iCnt < Arr.length; iCnt++)
        {
            Arr[iCnt]++;
        }
    }

    public static void main(String A[])
    {
       Scanner sobj = new Scanner(System.in);

        int iCnt = 0;

        System.out.println("Enter the number of elements : ");
        int iLength = sobj.nextInt();

        int Brr[] = new int[iLength];

        System.out.println("Array Elements Before function call : ");

        for(iCnt = 0; iCnt < Brr.length; iCnt++)
        {
           Brr[iCnt] = sobj.nextInt();
        }

        Update(Brr);

        System.out.println("Array Elements After function call : ");

        for(iCnt = 0; iCnt < Brr.length; iCnt++)
        {
           System.out.println(Brr[iCnt]);
        }

        Brr = null;
        System.gc();
    }
}