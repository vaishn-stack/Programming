package Assignment56;

import java.util.*;

public class A276 
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        int ino = 0, isqrt = 0, iSum = 0;

        System.out.println("Enter the number : ");
        ino = sobj.nextInt();

        while(isqrt > 0)
        {
            iSum = iSum + isqrt % 10;
            isqrt = isqrt / 10;
        }

        if(iSum == ino)
        {
            System.out.println("It is Neon number");
        }
        else
        {
            System.out.println("It is not Neon number");
        }
    }
    
}
