package Assignment52;

import java.util.Scanner;

public class A258 
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        int[] marks = new int[5];
        boolean failed = false;
        int total = 0;

        int i = 0;

        System.out.println("Enter marks of 5 subjects : ");

        for(i = 0; i < 5; i++)
        {
            marks[i] = sobj.nextInt();

            if(marks[i] < 0 || marks[i] > 100)
            {
                System.out.println("Invalid input");
                return;
            }

            if(marks[i] < 35)
            {
                failed = true;
            }

            total = total + marks[i];
        }

        if(failed)
        {
            System.out.println("Result : Fail");
        }
        else
        {
            double average = total / 5.0;

            String classification;

            if(average >= 75)
            {
                classification = "Distinction";
            }
            else if(average >= 60)
            {
                classification = "First Class";
            }
            else if(average >= 50)
            {
                classification = "Second Class";
            }
            else
            {
                classification = "Pass";
            }

            System.out.println("Average Marks : " + average);
            System.out.println("Final Result : " + classification);
        }

        sobj.close();
    }
}
