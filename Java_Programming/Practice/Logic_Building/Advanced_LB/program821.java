/*
    palindromeumber or Niven number 
*/

import java.io.*;

public class program821
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iTemp = 0;
        int iDigit = 0;
        int iRev = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;
            iRev = iRev * 10 + iDigit;
            iNo = iNo / 10;
        }

        System.out.println(iRev);
        
       
    }
}
