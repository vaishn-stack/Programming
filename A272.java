package Assignment55;

import java.util.Scanner;

public class A272
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iNo = 0, iDigit = 0;
        int itemp = 0, iSum = 0, iCount = 0;
    
        System.out.println("Enter the number : ");
        iNo = sobj.nextInt();

        itemp = iNo;

        while(iNo > 0)
        {
            iCount++;
            itemp = itemp / 10;
        }

        while(itemp > 0)
        {
            iDigit = itemp % 10;
            iSum = iSum + (int)Math.pow(iDigit, iCount);
            itemp = itemp / 10;
        }

        if(iSum == iNo)
        {
            System.out.println("It is Armstrong number");
        }
        else
        {
            System.out.println("It is not Armstrong number");
        }
    }
    
}
