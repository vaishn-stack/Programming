// Linear pattern Printing 
// Input : 11
// Output : * * * *
//          * * * *
//          1 2 3 4 

import java.util.*;

public class program189
{
   
    public static void Display()
    {
        int iCnt = 0;

        for(iCnt = 1; iCnt <= 4; iCnt++)
        {
            System.out.print("*\t");
        }
        System.out.println();

        for(iCnt = 1; iCnt <= 4; iCnt++)
        {
            System.out.print("*\t");
        }
        System.out.println();
    }


    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iValue = 0;

       // System.out.println("Enter the Number of Elements : ");
       // iValue = sobj.nextInt();

        Display();
    }
}