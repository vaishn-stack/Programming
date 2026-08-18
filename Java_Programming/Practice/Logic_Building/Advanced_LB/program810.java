// Input - 5!
// output - 5 * 4 * 3 * 2 * 1

import java.io.*;

public class program810
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        // long iNo = 0;
        int  iDigit = 0;
        long iFact = 0;
        long iSum = 0;
        int iTemp = 0;

       // int i = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number : ");
        // ParseInt - string to int convert
        iNo = Integer.parseInt(bobj.readLine());

        iFact = 1;
        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;

            while(iDigit != 0)
            {
                iFact = iFact * iDigit;
                iDigit--;
            }

            iSum = iSum + iFact;

            iNo = iNo / 10;

            iFact = 1;
        }

        if(iSum == iTemp)
        {
            System.out.println("It is strong number");
        }
        else
        {
            System.out.println("It is not strong number");
        }
       
    }
}
