// Linear pattern Printing
// Input : 5
// Output : *1* *2* *3* *4* *5*

import java.util.*;

public class program175
{
    public static void Display(int iNo)
    {
        int iCnt = 0;

        for(iCnt = 1; iCnt <= iNo; iCnt++)
        {
            System.out.print("*" + iCnt + "*\t");
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
