package Assignment56;

import java.util.*;

public class A277
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        int ino = 0, isqrt = 0, iSum = 0, itemp = 0;
        boolean flag = true;

        System.out.println("Enter the number : ");
        ino = sobj.nextInt();
        
        while(itemp > 0)
        {
            if(itemp % 10 != isqrt % 10)
            {
                flag = false;
                itemp = itemp / 10;
                isqrt = isqrt / 10;
            }
        }

        if(flag)
        {
            System.out.println("It is Automorphic number");
        }
        else
        {
            System.out.println("It is not Automorphic number");
        }
    }
    
}
