package Assignment54;

import java.util.Scanner;

public class A268 
{
     public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter parcel weight in kg: ");
        int weight = sobj.nextInt();

        if(weight <= 0)
        {
            System.out.println("Invalid input");
        }
        else
        {
            int charge;

            if(weight <= 1)
            {
                charge = 50;
            }
            else if(weight <= 5)
            {
                charge = 50 + ((weight - 1) * 20);
            }
            else
            {
                charge = 150 + ((weight - 5) * 30);
            }

            System.out.println("Parcel Weight: " + weight + " kg");
            System.out.println("Courier Charge: Rs." + charge);
        }
        
        sobj.close();
    }
}
