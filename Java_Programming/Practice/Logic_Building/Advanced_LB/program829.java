/*
    automorphic number - square ends with the exact same digits as the same as that number
    eg - 121 = 121 
*/

import java.io.*;

public class program829
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iTemp = 0;
        int iSquare = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        iSquare = iNo * iNo;

        while(iNo != 0)
        {
            if(iNo % 10 != iSquare % 10)
            {
                break;
            }
            iNo = iNo / 10;
            iSquare = iSquare / 10;
        }

        if(iNo == 0)
        {
            System.out.println("It is a Automorphic number");
        }
        else
        {
            System.out.println("It is not Automorphic number");
        }
    }
}
