package Assignment51;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.zip.CRC32;

public class A254
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
                FileInputStream fiobj =
                    new FileInputStream(fobj);

                CRC32 crc = new CRC32();

                int Data;

                while((Data = fiobj.read()) != -1)
                {
                    crc.update(Data);
                }

                fiobj.close();

                System.out.println("Checksum of file is : "
                                   + crc.getValue());
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
