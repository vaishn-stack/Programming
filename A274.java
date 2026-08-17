package Assignment55;

import java.util.Scanner;

public class A274
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iNo = 0;
        int iSum = 0, itemp = 0;
        int i = 0;
    
        System.out.println("Enter the number : ");
        iNo = sobj.nextInt();

        itemp = iNo;

        while(itemp > 0)
        {
            iSum = iSum + itemp % 10;
            itemp = itemp / 10;
        }
        

        if(iNo % iSum == 0)
        {
            System.out.println("It is Harshad number");
        }
        else
        {
            System.out.println("It is not Harshad number");
        }
    }
    
}
