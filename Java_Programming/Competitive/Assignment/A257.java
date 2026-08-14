package Assignment52;

import java.util.Scanner;

public class A257 
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter current balance: ");
        int balance = sobj.nextInt();

        System.out.print("Enter withdrawal amount: ");
        int withdrawAmount = sobj.nextInt();

        if(balance < 0 || withdrawAmount <= 0)
        {
            System.out.println("Invalid input");
        }
        else if(withdrawAmount % 100 != 0)
        {
            System.out.println("Transaction Failed: Amount must be a multiple of ₹100");
        }
        else if(withdrawAmount > 25000)
        {
             System.out.println("Transaction Failed: Miximum withdrawal limit is rs.25,000");
        }
        else if(balance - withdrawAmount < 1000)
        {
            System.out.println("Transaction Failed: Minimum balance of ₹1,000 must be maintained");
        }
        else
        {
            int newBalance = balance - withdrawAmount;
            
            System.out.println("Transaction Successful.");
            System.out.println("Remaining Balance: rs." + newBalance);
        }
        sobj.close();
    } 
}
