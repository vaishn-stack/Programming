

import java.io.*;

public class program664
{
    public static void main(String a[]) throws IOException
    {
        FileWriter fwobj = new FileWriter("Demo.txt");

        fwobj.write("Jay Ganesh...");

        fwobj.close();    // close kelyavr data file madhe lihla jato - IMP
    }
}

