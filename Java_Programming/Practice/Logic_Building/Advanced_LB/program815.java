// Input - 153
// output - 1^3 + 5^3 + 3^3 = 153
// number raised to that total number 
// Armstrong number
/*
    x =3, y =5 
    3*3*3*3*3
*/

import java.io.*;

public class program815
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iCount = 0;
        int iTemp = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number as a base : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;   // backup

        while(iNo != 0)
        {
            iCount++;
            iNo = iNo / 10;
        }

        System.out.println("Number of digits are : " + iCount);
        
       
    }
}
