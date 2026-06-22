import java.util.*;

class DigitX
{
    public void DisplayDigit(int iNo)
    {
        int iDigit = 0;

        for(iNo = 0; iNo != 0; iNo ++)          // for(;;)
        {
            iDigit = iNo % 10;
            System.out.println(iDigit);
            iNo = iNo / 10;        
        }
    }
}

public class program81
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        DigitX dobj = new DigitX();

        int iValue = 0;

        System.out.println("Enter Number : ");
        iValue = sobj.nextInt();

        dobj.DisplayDigit(iValue);
    }
}

// time complexity = O(N)