//check whether value is palindrome or not

import java.util.*;

class DigitX
{
    public boolean CheckPalindrome(int iNo)
    {
        int iDigit = 0;
        int iRev = 0;
        int iTemp =0;

        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;
            iRev = (iRev * 10) + iDigit;
            iNo = iNo / 10;
        }

        if(iRev == iTemp)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

public class program93
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        DigitX dobj = new DigitX();

        int iValue = 0;
        boolean bRet = false;

        System.out.println("Enter Number : ");
        iValue = sobj.nextInt();

        bRet = dobj.CheckPalindrome(iValue);

        if(bRet == true)
        {
            System.out.println("Number is Palindrome.");
        }
        else
        {
            System.out.println("Number is not Palindrome.");
        }
    }
}
