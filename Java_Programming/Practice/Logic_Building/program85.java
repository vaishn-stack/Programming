// calculate the frequency of digits

import java.util.*;

class DigitX
{
    public int CountDigit(int iNo)
    {
        int iDigit = 0;
        int iCount = 0;

        while(iNo != 0)
        {
            iDigit = iNo % 10;

            if(iDigit == 7)
            {
                iCount++;
            }

            iNo = iNo / 10;
        }
        
        return iCount;
    }
}

public class program85
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        DigitX dobj = new DigitX();

        int iValue = 0;
        int iRet = 0;

        System.out.println("Enter Number : ");
        iValue = sobj.nextInt();

        iRet = dobj.CountDigit(iValue);

        System.out.println("Frequency of digits are : " + iRet);
    }
}
