import java.util.*;

class DigitX
{
    public int SumDigits(int iNo)
    {
        int iSum = 0;

        while(iNo != 0)
        {
            iSum = (iNo % 10) + iSum;
        }
        
        return iSum;
    }
}

public class program91
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        DigitX dobj = new DigitX();

        int iValue = 0;
        int iRet = 0;

        System.out.println("Enter Number : ");
        iValue = sobj.nextInt();

        iRet = dobj.SumDigits(iValue);

        System.out.println("Summation of digits : " + iRet);
    }
}
