

import java.io.*;
import java.util.Scanner;

public class program723
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);

        //String header = null;

        String FolderName = null;
        String PackFileName = null;

        FileOutputStream foobj = null;
        FileInputStream fiobj = null;

        System.out.println("Enter folder name : ");
        FolderName = sobj.nextLine();

        System.out.println("Enter the name of Packed File : ");
        PackFileName = sobj.nextLine();

        File fobjFolder = new File(FolderName);

        // int iRet = 0;

        // byte Buffer[] = new byte[1024];

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

                System.out.println(fArr[i].length());
                
                // Write file name and size 

                

                /*// Loop to read from fiobj & write to foobj

                while((iRet = fiobj.read(Buffer)) != -1)
                {
                    foobj.write(Buffer, 0, iRet);
                }
                */
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

