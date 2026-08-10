

import java.io.*;
import java.util.Scanner;

public class program693
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);

        String FolderName = null;
        String PackFileName = null;

        FileOutputStream foobj = null;
        FileInputStream fiobj = null;

        System.out.println("Enter folder name : ");
        FolderName = sobj.nextLine();

        System.out.println("Enter the name of Packed File : ");
        PackFileName = sobj.nextLine();

        File fobjFolder = new File(FolderName);

        int iRet = 0;

        byte Buffer[] = new byte[1024];

        if((fobjFolder.exists()) && (fobjFolder.isDirectory()))
        {
            System.out.println("Folder exists");

            File fobjPack = new File(PackFileName);
            fobjPack.createNewFile();           // Pack file created

            foobj = new FileOutputStream(fobjPack);

            File fArr[] = fobjFolder.listFiles();

            System.out.println("Number of files in Folder : "+fArr.length);

            for(int i = 0; i < fArr.length; i++)
            {
                fiobj = new FileInputStream(fArr[i]);

                System.out.println(fArr[i].getName());
                
                // Write file name and size 
                // data


                // Loop to read from fiobj & write to foobj

                fiobj.close();
            }

            foobj.close();
            sobj.close();
        }
        else
        {
            System.out.println("There is no such folder");
        }
    }
}

