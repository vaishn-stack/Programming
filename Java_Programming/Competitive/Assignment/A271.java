package Assignment55;

import java.util.Scanner;

public class A271 
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iNo = 0, iDigit = 0, iFact = 0;
        int itemp = 0, iSum = 0;
        int i = 0;

        System.out.println("Enter the number : ");
        iNo = sobj.nextInt();

        itemp = iNo;

        while(iNo > 0)
        {
            iDigit = iNo % 10;
            iFact = 1;

            for(i = 1; i <= iDigit; i++)
            {
                iFact = iFact * i;
                iSum = iSum + iFact;
                iNo = iNo / 10;
            }
        }

        if(iSum == itemp)
        {
            System.out.println("It is strong number");
        }
        else
        {
            System.out.println("It is not strong number");
        }
    }
    
}
