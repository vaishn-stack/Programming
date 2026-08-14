package Assignment54;

import java.util.Scanner;

public class A267 
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter marks percentage: ");
        int marks = sobj.nextInt();

        System.out.print("Enter attendance percentage: ");
        int attendance = sobj.nextInt();

        System.out.print("Enter family income: ");
        int income = sobj.nextInt();

        if(marks < 0 || marks > 100)
        {
            System.out.println("Invalid marks");
        }
        else if(attendance < 0 || attendance > 100)
        {
            System.out.println("Invalid attendance");
        }
        else if(income < 0)
        {
            System.out.println("Invalid income");
        }
        else if(marks < 80)
        {
            System.out.println("Scholarship Rejected: Marks must be at least 80%");
        }
        else if(attendance < 75)
        {
            System.out.println("Scholarship Rejected: Attendance must be at least 75%");
        }
        else if(income > 300000)
        {
            System.out.println("Scholarship Rejected: Family income exceeds ₹3,00,000");
        }
        else
        {
            System.out.println("Scholarship Approved");
        }
        sobj.close();
    }
    
}
