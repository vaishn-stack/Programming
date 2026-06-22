// Linear pattern Printing
// Input : 7
// Output : 1 * 3 * 5 * 7

import java.util.*;

public class program176
{
    public static void Display(int iNo)
    {
        int iCnt = 0;

        for(iCnt = 1; iCnt <= iNo; iCnt ++)
        {
            // System.out.print(iCnt + "\t*\t");       // 1 * 3 * 5 * 7 *

            if(iCnt % 2 == 0)
            {
                System.out.print("*\t");
            }
            else
            {
                System.out.print(iCnt + "\t");
            }
        }
        System.out.println();
    }

    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iValue = 0;

        System.out.println("Enter the Number of Elements : ");
        iValue = sobj.nextInt();

        Display(iValue);
    }
}
