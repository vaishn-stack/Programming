

import java.io.*;

public class program666
{
    public static void main(String a[]) 
    {
        FileReader frobj = null;

        try
        {
            frobj = new FileReader("Demo.txt");   

            System.out.println(frobj.read());
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

