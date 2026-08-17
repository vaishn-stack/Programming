package Assignment55;

import java.util.Scanner;

public class A273
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iNo = 0;
        int iSum = 0;
        int i = 0;
    
        System.out.println("Enter the number : ");
        iNo = sobj.nextInt();

        for(i = 1; i < iNo; i++)
        {
            if(iNo % i == 0)
            {
                iSum = iSum + i;
            }
        }
        

        if(iSum == iNo)
        {
            System.out.println("It is Perfect number");
        }
        else
        {
            System.out.println("It is not Perfect number");
        }
    }
    
}
