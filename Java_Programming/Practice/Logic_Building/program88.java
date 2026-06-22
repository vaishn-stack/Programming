// calculate the count even odd digits

import java.util.*;

class DigitX
{
    public void CountEvenOdd(int iNo)
    {
        int iDigit = 0;
        int iCountEven = 0, iCountOdd = 0;

        while(iNo != 0)
        {
            iDigit = iNo % 10;

            if(iDigit % 2 == 0)
            {
                iCountEven++;
            }
            else
            {
                iCountOdd++;
            }

            iNo = iNo / 10;
        }
        System.out.println("Number of Even Digits : " +iCountEven);
        System.out.println("Number of Odd Digits : " +iCountOdd);     
    }
}

public class program88
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        DigitX dobj = new DigitX();

        int iValue = 0;

        System.out.println("Enter Number : ");
        iValue = sobj.nextInt();

        dobj.CountEvenOdd(iValue);

    }
}
