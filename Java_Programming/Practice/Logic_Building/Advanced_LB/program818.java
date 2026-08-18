/*
    Harshad number or Niven number - it can be divided evenly by the sum of its own digits
    eg - 1 + 8 = 9 or 18 / 9 = 2
*/

import java.io.*;

public class program818
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        // int iCount = 0;
        int iTemp = 0;
        int iDigit = 0;
        int iSum = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;
            iSum = iSum + iDigit;
            iNo = iNo / 10;
        }

        System.out.println("Summation is : "+ iSum);

        
       
    }
}
