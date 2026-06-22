// Linear pattern Printing 
// Input : 11
// Output : * * * # # # * * * # #
//          1 2 3 4 5 6 7 8 9 10 11
// 3 vela vaprlya vr loop phirla pahije - nested loop

import java.util.*;

public class program188
{
    public static void Display(int iNo)
    {
        int iCnt = 0;
        //int iCount = 0;

        for(iCnt = 1; iCnt <= iNo; iCnt++)
        {
            if(((iCnt - 1) / 3) % 2 == 0)
            {
                System.out.print("*\t");
            }
            else
            {
                System.out.print("#\t");
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