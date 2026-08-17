package Assignment56;

import java.util.*;

public class A279
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        int ino = 0, n = 0, i = 0;

        n = ino + 1;
        i = 1;

        System.out.println("Enter the number : ");
        ino = sobj.nextInt();
        
        while(i * i < n)
        {
           i++;
        }

        if(i * i == n)
        {
            System.out.println("It is Sunny number");
        }
        else
        {
            System.out.println("It is not Sunny number");
        }
        sobj.close();
    }
    
}
