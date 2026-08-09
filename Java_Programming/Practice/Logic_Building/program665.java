

import java.io.*;

public class program665
{
    public static void main(String a[]) 
    {
        FileWriter fwobj = null;

        try
        {
            fwobj = new FileWriter("Demo.txt");   // data override hotoy
            fwobj.write("Jay Ganesh...");

            fwobj.close();
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

