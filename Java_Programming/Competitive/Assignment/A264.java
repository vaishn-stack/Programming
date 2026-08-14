package Assignment53;

import java.util.Scanner;

public class A264 
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Helmet worn (Yes/No): ");
        String helmet = sobj.next();

        System.out.print("License available (Yes/No): ");
        String license = sobj.next();

        System.out.print("Overspeeding (Yes/No): ");
        String speed = sobj.next();

        if((!helmet.equalsIgnoreCase("Yes") &&
            !helmet.equalsIgnoreCase("No")) ||
           (!license.equalsIgnoreCase("Yes") &&
            !license.equalsIgnoreCase("No")) ||
           (!speed.equalsIgnoreCase("Yes") &&
            !speed.equalsIgnoreCase("No")))
        {
            System.out.println("Invalid input. Enter Yes/No only.");
        }
        else
        {
            int fine = 0;

            if(helmet.equalsIgnoreCase("No"))
            {
                fine = fine + 500;
            }

            if(license.equalsIgnoreCase("No"))
            {
                fine = fine + 1000;
            }

            if(speed.equalsIgnoreCase("Yes"))
            {
                fine = fine + 1500;
            }

            System.out.println("Total Fine Amount: Rs." + fine);
        }

        sobj.close();
    }
}
