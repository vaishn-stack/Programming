import java.io.*;

public class program803
{
    public static void main(String A[]) throws Exception
    {
        int iNo = 0;
        int iDigit = 0;

        BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter number : ");

        // ParseInt - String to int conversion
        iNo = Integer.parseInt(bobj.readLine());

        System.out.println("Input value is : " + iNo);

        while(iNo != 0)
        {
            iDigit = iNo % 10;
            System.out.println(iDigit);

            iNo = iNo / 10;
        }

        bobj.close();
    }
}