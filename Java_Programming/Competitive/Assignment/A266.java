package Assignment54;

import java.util.Scanner;

public class A266 
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter distance in km: ");
        int distance = sobj.nextInt();

        System.out.print("Peak Hour (Yes/No): ");
        String peakHour = sobj.next();

        if(distance < 0)
        {
            System.out.println("Invalid input");
        }
        else if(!peakHour.equalsIgnoreCase("Yes") &&
                !peakHour.equalsIgnoreCase("No"))
        {
            System.out.println("Invalid Peak Hour input");
        }
        else
        {
            double fare = 50;

            if(distance <= 10)
            {
                fare = fare + (distance * 12);
            }
            else
            {
                fare = fare + (10 * 12);
                fare = fare + ((distance - 10) * 15);
            }

            if(peakHour.equalsIgnoreCase("Yes"))
            {
                fare = fare + (fare * 0.20);
            }

            System.out.println("Distance: " + distance + " km");
            System.out.println("Peak Hour: " + peakHour);
            System.out.println("Total Fare: Rs." + fare);
        }

        sobj.close();
    }
}
