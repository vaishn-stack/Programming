// Linear pattern Printing
// Input : 7
// Output : a b c d e f g

import java.util.*;

public class program179
{
    public static void Display(int iNo)
    {
        int iCnt = 0;       
        char ch = 'a';

        for(iCnt = 1; iCnt <= iNo; iCnt ++)
        {
               System.out.print(ch + "\t");
               ch++; 
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
