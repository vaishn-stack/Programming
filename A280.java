package Assignment56;

import java.util.*;

public class A280
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        int ino = 0, n = 0, i = 0, itemp = 0, icount = 0, iSum = 0, idigit = 0;

        itemp = ino;

        System.out.println("Enter the number : ");
        ino = sobj.nextInt();
        
        while(itemp > 0)
        {
           icount++;
           itemp = itemp / 10;
        }

        itemp = ino;

        while(itemp > 0)
        {
            idigit = itemp % 10;
            iSum = iSum + (int)Math.pow(idigit, icount);
            icount--;
            itemp = itemp / 10;

        }

        if(iSum == ino)
        {
            System.out.println("It is Disarium number");
        }
        else
        {
            System.out.println("It is not Disarium number");
        }
        sobj.close();
    }
    
}
