// Factors

import java.util.Scanner;

class NumberX
{
     public void DisplayFactors(int iNo)
     {
          // Logic
          int iCnt = 0;

          for (iCnt = 1; iCnt < iNo; iCnt++) 
          {
              if((iNo % iCnt) == 0)
              {
                    System.out.println(iCnt);
              }
          }
     }
}

public class program46
{
     public static void main(String A[])     
     { 
          Scanner sobj = new Scanner(System.in);

          int iValue = 0; 

          System.out.println("Enter number : ");
          iValue = sobj.nextInt();

          System.out.println("---------------------");

          NumberX nobj = new NumberX();  

          nobj.DisplayFactors(iValue);
     }
}

// Time Complexity : O(N)
// Where N >= 0