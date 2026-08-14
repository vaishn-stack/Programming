package Assignment54;

import java.util.Scanner;

public class A270 
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter battery percentage: ");
        int battery = sobj.nextInt();

        if(battery < 0 || battery > 100)
        {
            System.out.println("Invalid battery percentage");
        }
        else
        {
            String status;

            if(battery <= 5)
            {
                status = "Critical";
            }
            else if(battery <= 15)
            {
                status = "Low";
            }
            else
            {
                status = "Normal";
            }

            System.out.println("Battery Percentage: " + battery + "%");
            System.out.println("Status: " + status);
        }

        sobj.close();
    }
}
