// Input - 153
// output - 1^3 + 5^3 + 3^3 = 153
// number raised to that total number 
// Armstrong number
/*
    x =3, y =5 
    3*3*3*3*3
*/

import java.io.*;

public class program813
{
    public static void main(String A[]) throws Exception
    {
        int x = 0;
        int y = 0;
        int iPower = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number as a base : ");
        x = Integer.parseInt(bobj.readLine());

        System.out.println("Enter number as a power : ");
        y = Integer.parseInt(bobj.readLine());

        iPower = 1;

        while(y != 0)
        {
            iPower = iPower * x;
            y--;
        }

        System.out.println("Result is : " + iPower);
        
       
    }
}
