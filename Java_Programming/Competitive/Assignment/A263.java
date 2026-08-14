package Assignment53;

import java.util.Scanner;

public class A263 
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter current stock: ");
        int stock = sobj.nextInt();

        System.out.print("Enter requested quantity: ");
        int quantity = sobj.nextInt();

        if(stock < 0)
        {
            System.out.println("Invalid input: Stock cannot be negative");
        }
        else if(quantity <= 0)
        {
            System.out.println("Invalid input: Requested quantity must be greater than 0");
        }
        else if(quantity > stock)
        {
            System.out.println("Order Failed: Insufficient Stock.");
        }
        else
        {
            
            stock = stock - quantity;

            System.out.println("Order Processed Successfully.");
            System.out.println("Remaining Stock: " + stock);

            if(stock < 5)
            {
                System.out.println("Low Stock Alert!");
            }
        }
        sobj.close();
    }

}
