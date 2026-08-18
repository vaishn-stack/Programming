/*
    automorphic number - square ends with the exact same digits as the same as that number
    eg - 121 = 121 
*/

import java.io.*;

public class program823
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iTemp = 0;
        int iDigit = 0;
        int iSquare = 0;
        int iCount = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;
        iSquare = iNo * iNo;

        while(iNo != 0)
        {
           iCount++;
           iNo = iNo / 10;
        }

        // if(iSquare == iTemp)
        // {
        //     System.out.println("It is a Automorphic number");
        // }
        // else
        // {
        //     System.out.println("It is a not Automorphic number");
        // }
    }
}
