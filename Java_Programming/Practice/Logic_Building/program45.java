// number divisible by 3 and 5
// Type 3 - Final code

import java.util.Scanner;

class NumberX
{
     public boolean CheckDivisible(int iNo)
     {
          if((iNo % 3 == 0) && (iNo % 5 == 0))
          { 
               return true;
          }
          else
          {
               return false;
          }
     }
}

public class program45
{
     public static void main(String A[])     
     { 
          Scanner sobj = new Scanner(System.in);

          int iValue = 0; 
          boolean bRet = false;

          System.out.println("Enter number : ");
          iValue = sobj.nextInt();

          NumberX nobj = new NumberX();

          bRet = nobj.CheckDivisible(iValue);      

          if(bRet == true)
          {
               System.out.println("Number is divisible by 3 & 5.");
          }
          else
          {
               System.out.println("Number is not divisible by 3 & 5.");
          }
     }
}