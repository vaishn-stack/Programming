package Assignment52;

import java.util.Scanner;

public class A256 
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter total number of days : ");
        int daysKept = sobj.nextInt();

        if(daysKept < 0)
        {
            System.out.println("Invalid input");
        }
        else if(daysKept <= 7)
        {
            System.out.println("Returned on time. No file applicable.");
        }
        else
        {
            int fineAmount;

            if(daysKept <= 12)
            {
                fineAmount = (daysKept - 7) * 5;
            }
            else
            {
                fineAmount = (5 * 5) + ((daysKept - 12) * 10);
            }

            System.out.println("Total fine to be paid : Rs." + fineAmount);
        }
        
        sobj.close();
    }
}
