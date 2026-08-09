

import java.io.*;

public class program668
{
    public static void main(String a[]) 
    {
        FileReader frobj = null;

        int iRet = 0;

        try
        {
            frobj = new FileReader("Demo.txt");   

            while((iRet = frobj.read()) != -1)
            {
                System.out.println((char)iRet);
            }
        }
        catch(IOException iobj)
        {
            System.out.println(iobj);
        }
        finally
        {
            
        }
    }
}

