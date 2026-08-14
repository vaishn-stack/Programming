package Assignment52;

import java.util.Scanner;

public class A259 
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter units consumed: ");
        int units = sobj.nextInt();

        if(units < 0)
        {
            System.out.println("Invalid input");
        }
        else
        {
            int bill;

            if(units <= 100)
            {
                bill = units * 5;
            }
            else if(units <= 200)
            {
                bill = (100 * 50) + ((units - 100) * 7);
            }
            else
            {
                bill = (100 * 5) + (100 * 7) + ((units - 200) * 10);
            }
            System.out.println("Total Units Consumed: " + units);
            System.out.println("Total Electricity Bill: Rs." + bill);
        }
        sobj.close();
    }
}
