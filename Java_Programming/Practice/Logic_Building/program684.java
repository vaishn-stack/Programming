

import java.io.*;
import java.util.Scanner;

public class program684
{
    public static void main(String a[]) throws Exception
    {
        String FnameSrc = null;
        String Fnamedest = null;

        Scanner sobj = new Scanner(System.in);

        File fobjSrc = null;
        File fobjdest = null;

        FileInputStream fiobj = null;
        FileOutputStream foobj = null;

        int iRet = 0;

        System.out.println("Enter the Source file name : ");
        FnameSrc = sobj.nextLine();

        System.out.println("Enter the Destination file name : ");
        Fnamedest = sobj.nextLine();

        // Create source and destination file objects
        fobjSrc = new File(FnameSrc);
        fobjdest = new File(Fnamedest);

        // Check whether source file exists
        if (!fobjSrc.exists())
        {
            System.out.println("There is no such source file.");
            sobj.close();
            return;
        }

        // Check whether source is a file
        if (!fobjSrc.isFile())
        {
            System.out.println("Source is not a regular file.");
            sobj.close();
            return;
        }

        // Create input and output streams
        fiobj = new FileInputStream(fobjSrc);
        foobj = new FileOutputStream(fobjdest);

        // Create buffer
        byte Buffer[] = new byte[100];

        // Read data from source and write data into destination
        while ((iRet = fiobj.read(Buffer)) != -1)
        {
            foobj.write(Buffer, 0, iRet);
        }

        // Close streams
        fiobj.close();
        foobj.close();

        System.out.println("Data Copied Successfully.");

        sobj.close();
    }
}