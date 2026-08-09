

import java.io.*;

public class program663
{
    public static void main(String a[]) throws IOException
    {
        FileWriter fwobj = new FileWriter("Demo.txt"); // file create krto and lihto pn

        fwobj.write("Jay Ganesh...");

        fwobj.close();
        
    }
}

