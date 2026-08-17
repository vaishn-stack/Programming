package Assignment57;

import java.util.Scanner;

public class A281 
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        int ino = 0;
        int icube = ino * ino * ino;
        int itemp = ino;
        boolean flag = true;

        System.out.println("Enter the number : ");
        ino = sobj.nextInt();
        
        while(itemp > 0)
        {
            if(itemp % 10 != icube % 10)
            {
                flag = false;

                itemp = itemp / 10;
                icube = icube / 10;
            }
        }

        if(flag)
        {
            System.out.println("It is Trimorphic Number");
        }
        else
        {
            System.out.println("It is not Trimorphic Number");
        }
    }
}
