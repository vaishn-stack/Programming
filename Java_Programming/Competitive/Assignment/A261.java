package Assignment53;

import java.util.Scanner;

public class A261 
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter total parking hours: ");
        int hours = sobj.nextInt();

        if(hours < 0)
        {
            System.out.println("Invalid input");
        }
        else
        {
            int fee;

            if(hours <= 2)
            {
                fee = 20;
            }
            else
            {
                fee = 20 + ((hours - 2) * 10);
            }

            if(hours > 10)
            {
                fee = fee + 50;
            }

            System.out.println("Total Parking Duration: " + hours + " hours");
            System.out.println("Total Parking Fee: Rs." + fee);
        }

        sobj.close();
    }    
}
