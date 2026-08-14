package Assignment54;

import java.util.Scanner;

public class A269 
{
      public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter budget amount: ");
        int budget = sobj.nextInt();

        System.out.print("Enter number of items: ");
        int n = sobj.nextInt();

        if(budget < 0)
        {
            System.out.println("Invalid budget");
            sobj.close();
            return;
        }

        if(n < 0)
        {
            System.out.println("Invalid number of items");
            sobj.close();
            return;
        }

        int balance = budget;
        int count = 0;

        for(int i = 1; i <= n; i++)
        {
            System.out.print("Enter price of item " + i + ": ");
            int price = sobj.nextInt();

             if(price <= 0)
            {
                System.out.println("Invalid price");
                sobj.close();
                return;
            }

            if(price <= balance)
            {
                balance = balance - price;
                count++;
            }
            else
            {
                break;
            }
        }
        System.out.println("Items Purchased: " + count);
        System.out.println("Remaining Balance: Rs." + balance);

        sobj.close();
    }
}
