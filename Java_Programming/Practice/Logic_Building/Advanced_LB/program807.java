// Input - 5!
// output - 5 * 4 * 3 * 2 * 1
import java.io.*;

public class program807
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
       // int  iDigit = 0;
        int iFact = 0;
       // int iSum = 0;
       // int iTemp = 0;

       // int i = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number : ");
        // ParseInt - string to int convert
        iNo = Integer.parseInt(bobj.readLine());

        iFact = 1;

        while(iNo != 0)
        {
            iFact = iFact * iNo;
            iNo--;
        }

        System.out.println("Factorial is : " + iFact);

        

        //bobj.close();
    }
}
