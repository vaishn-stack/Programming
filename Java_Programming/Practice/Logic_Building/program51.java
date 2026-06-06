// Prime number

import java.util.Scanner;

class NumberX
{

     public boolean CheckPerfect(int iNo)
     {
          int iCnt = 0;
          int iSum = 0;

          for (iCnt = 1; iCnt <= (iNo / 2); iCnt++) 
          {
              if((iNo % iCnt) == 0)
              {
                    iSum = iSum + iCnt;
              }

              if(iSum > iNo)
              {
                    break;
              }
          }

          if(iSum == iNo)
          {
               return true;
          }
          else
          {
               return false;
          }
          
     }
}

public class program51
{
     public static void main(String A[])     
     { 
          Scanner sobj = new Scanner(System.in);

          int iValue = 0; 
          boolean bRet = false;

          System.out.println("Enter number : ");
          iValue = sobj.nextInt();

          System.out.println("---------------------");

          NumberX nobj = new NumberX();  

          bRet = nobj.CheckPerfect(iValue);

          if(bRet == true)
          {
               System.out.println("It is Perfect.");
          }
          else
          {
               System.out.println("It is not Perfect.");
          }
          
     }
}

// Time Complexity : O(N / 2)
// Where N >= 0