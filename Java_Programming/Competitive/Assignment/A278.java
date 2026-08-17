package Assignment56;

import java.util.*;

public class A278
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        int ino = 0, iSum = 0, iproduct = 0, idigit = 0;

        iproduct = 1;

        System.out.println("Enter the number : ");
        ino = sobj.nextInt();
        
        while(ino > 0)
        {
            idigit = ino % 10;
            iSum = iSum + idigit;
            iproduct = iproduct * idigit;
            ino = ino / 10;
        }

        if(iSum == iproduct)
        {
            System.out.println("It is Spy number");
        }
        else
        {
            System.out.println("It is not Spy number");
        }
    }
    
}
