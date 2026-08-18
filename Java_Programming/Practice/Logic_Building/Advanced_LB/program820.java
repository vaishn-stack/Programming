/*
    Find the range of that numbers(prime number, plaindrome, armstrong , harshad)
*/

import java.io.*;

public class program820
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iDigit = 0;
        int iSum = 0;
        int iStart = 0;
        int iEnd = 0;
        int i = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter Starting Point : ");
        iStart = Integer.parseInt(bobj.readLine());

        System.out.println("Enter Ending Point : ");
        iEnd = Integer.parseInt(bobj.readLine());

        System.out.println("Harshad numbers are : ");

        for(i = iStart; i <= iEnd; i++)
        {
            iNo = i;

            while(iNo != 0)
            {
                iDigit = iNo % 10;
                iSum = iSum + iDigit;
                iNo = iNo / 10;
            }

            if(i % iSum == 0)
            {
                System.out.println(i);
            }
          
            iSum = 0;
        }
    }
}
