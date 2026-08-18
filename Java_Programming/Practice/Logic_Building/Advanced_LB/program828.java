/*
    automorphic number - square ends with the exact same digits as the same as that number
    eg - 121 = 121 
*/

import java.io.*;

public class program828
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iTemp = 0;
        int iSquare = 0;
        int iCount = 0;
        

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        String strNo = String.valueOf(iNo);
        iCount = strNo.length();
        
        iSquare = iNo * iNo;

        String strSquare = String.valueOf(iSquare);

        if(strSquare.endsWith(strNo))
        {
            System.out.println("It is Automorphic number");
        }
        else
        {
            System.out.println("It is not Automorphic number");
        }

    }
}
