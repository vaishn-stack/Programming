package Assignment52;

import java.util.Scanner;

public class A260
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter purchase amount: ");
        int amount = sobj.nextInt();

        System.out.print("Enter membership type (Premium/Regular): ");
        String membership = sobj.next();

        if(amount <= 0)
        {
            System.out.println("Invalid input: Amount must be greater than 0");
        }
        else if((!membership.equalsIgnoreCase("Premium")) &&
                (!membership.equalsIgnoreCase("Regular")))
        {
            System.out.println("Invalid membership type");
        }
        else
        {
            double discount = 0;

            if(amount > 5000)
            {
                discount = amount * 0.20;
            }
            else if(amount > 2000)
            {
                discount = amount * 0.10;
            }

            double discountAmount = amount - discount;

            double premiumDiscount = 0;

            if(membership.equalsIgnoreCase("Premium"))
            {
                premiumDiscount = discountAmount * 0.05;
            }

            double totalDiscount = discount + premiumDiscount;
            double finalAmount = amount - totalDiscount;

            System.out.println("Original Amount : Rs." + amount);
            System.out.println("Total Discount : Rs." + totalDiscount);
            System.out.println("Final Payable Amount : Rs." + finalAmount);
        }
        sobj.close();
    }
}
