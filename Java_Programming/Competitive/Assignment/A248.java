package Assignment50;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class A248
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter file name : ");
        String FileName = sobj.nextLine();

        File fobj = new File(FileName);

        if(fobj.exists() && fobj.isFile())
        {
            try
            {
                FileOutputStream foobj =
                    new FileOutputStream(fobj, true);

                System.out.println("Enter data to write : ");
                String Data = sobj.nextLine();

                foobj.write(Data.getBytes());

                foobj.close();

                System.out.println("Data written successfully.");
            }
            catch(Exception e)
            {
                System.out.println("Exception occurred : " + e);
            }
        }
        else
        {
            System.out.println("File does not exist.");
        }

        sobj.close();
    }
}