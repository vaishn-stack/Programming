// Problems on  - numbers, digits, n numbers
// Time complexity - no of iterations calculate krto for loop madhe(traversal)
// Space complexity - malloc, calloc, new asel teva ch calculate hote
// boiler plate code - write the extra code 
// number divisible by 3 and 5
// Type 1

import java.util.Scanner;

public class program39
{
    public static void main(String A[])     
    { 
       Scanner sobj = new Scanner(System.in);

       int iValue = 0;

       System.out.println("Enter number : ");
       iValue = sobj.nextInt();

       if((iValue % 3 == 0) && (iValue % 5 == 0))
       { 
            System.out.println("Number is divisible by 3 & 5.");
       }
       else
       {
            System.out.println("Number is not divisible by 3 & 5.");
       }
    }
}