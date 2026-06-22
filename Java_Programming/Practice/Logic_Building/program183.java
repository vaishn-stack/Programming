// Linear pattern Printing
// Input : 7
// Output : a b c d e f g
// ASCII values = 0 -> 48, A -> 65, a -> 97

import java.util.*;

public class program183
{
    public static void Display(int iNo)
    {
        int iCnt = 0;       
        char ch = '\0';

        for(iCnt = 1, ch = 65; iCnt <= iNo; iCnt ++, ch++)
        {
               System.out.print(ch + "\t");
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
