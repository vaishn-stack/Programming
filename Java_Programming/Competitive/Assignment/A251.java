package Assignment51;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class A251
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter source file name : ");
        String Source = sobj.nextLine();

        System.out.println("Enter destination file name : ");
        String Destination = sobj.nextLine();

        File SourceObj = new File(Source);
        File DestinationObj = new File(Destination);

        if(SourceObj.exists() && SourceObj.isFile())
        {
            try
            {
                FileInputStream fiobj =
                    new FileInputStream(SourceObj);

                FileOutputStream foobj =
                    new FileOutputStream(DestinationObj);

                int Data;

                while((Data = fiobj.read()) != -1)
                {
                    foobj.write(Data);
                }

                fiobj.close();
                foobj.close();

                System.out.println("Data copied successfully.");
            }
            catch(Exception e)
            {
                System.out.println("Exception occurred : " + e);
            }
        }
        else
        {
            System.out.println("Source file does not exist.");
        }

        sobj.close();
    }
}
