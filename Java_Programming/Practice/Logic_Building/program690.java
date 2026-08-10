

import java.io.*;
import java.util.Scanner;

public class program690
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);
        String FolderName = null;
        String PackFileName = null;

        System.out.println("Enter folder name : ");
        FolderName = sobj.nextLine();

        System.out.println("Enter the name of Packed File : ");
        PackFileName = sobj.nextLine();

        File fobjFolder = new File(FolderName);


        if((fobjFolder.exists()) && (fobjFolder.isDirectory()))
        {
            System.out.println("Folder exists");

            File fobjPack = new File(PackFileName);
            fobjPack.createNewFile(); // Pack file created

            File fArr[] = fobjFolder.listFiles();

            System.out.println("Number of files in Folder : "+fArr.length);

            for(int i = 0; i < fArr.length; i++)
            {
                // Logic
            }
        }
        else
        {
            System.out.println("There is no such folder");
        }
        sobj.close();
    }
}

