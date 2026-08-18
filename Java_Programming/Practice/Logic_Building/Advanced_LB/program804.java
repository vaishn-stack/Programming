import java.io.*;

public class program804
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int  iDigit = 0;
        int iFact = 0;
        int iSum = 0;
       
        BufferedReader bobj = new BufferedReader(new InputStreamReader((System.in)));

        System.out.println("Enter number : ");
        // ParseInt - string to int convert
        iNo = Integer.parseInt(bobj.readLine());

        System.out.println("Input value is : " + iNo);

        int iTemp = 0;

        while(iNo != 0)
        {
            iDigit = iNo % 10;
            System.out.println(iDigit);
            iNo = iNo / 10;
        }

        System.out.println("Original number is : "+ iTemp);

        //bobj.close();
    } // issue
}
