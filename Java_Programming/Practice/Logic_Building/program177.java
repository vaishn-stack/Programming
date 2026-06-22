// Linear pattern Printing
// Input : 7
// Output : 1 * 2 * 3 * 4

import java.util.*;

public class program177
{
    public static void Display(int iNo)
    {
        int iCnt = 0;
        int iCount = 0;     // Extra counter are uesd

        for(iCnt = 1, iCount = 1; iCnt <= iNo; iCnt ++)
        {
            if(iCnt % 2 == 0)
            {
               System.out.print("*\t");
            }
            else
            {
                System.out.print(iCount + "\t");
                iCount++;
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
