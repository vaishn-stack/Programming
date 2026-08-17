package Assignment55;

import java.util.Scanner;

public class A275
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iNo = 0;
        int itemp = 0;
        int rev = 0;
    
        System.out.println("Enter the number : ");
        iNo = sobj.nextInt();

        itemp = iNo;

        while(itemp > 0)
        {
            rev = rev * 10 + itemp % 10;
            itemp = itemp / 10;
        }
        

        if(rev == iNo)
        {
            System.out.println("It is Palindrome number");
        }
        else
        {
            System.out.println("It is not Palindrome number");
        }
    }
    
}
