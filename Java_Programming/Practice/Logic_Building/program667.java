

import java.io.*;

public class program667
{
    public static void main(String a[]) 
    {
        FileReader frobj = null;

        try
        {
            frobj = new FileReader("Demo.txt");   

            System.out.println((char)frobj.read());
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

