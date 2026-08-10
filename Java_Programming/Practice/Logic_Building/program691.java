import java.io.*;
import java.util.Scanner;

public class program691
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);

        String FolderName = null;
        String PackFileName = null;

        FileOutputStream foobj = null;
        FileInputStream fiobj = null;

        int iRet = 0;

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

            foobj = new FileOutputStream(fobjPack);

            File fArr[] = fobjFolder.listFiles();

            System.out.println("Number of files in Folder : "+fArr.length);

            byte Buffer[] = new byte[1024];

            for(int i = 0; i < fArr.length; i++)
            {
                // Loop to read from fiobj & write to foobj
                fiobj = new FileInputStream(fArr[i]);

                while((iRet = fiobj.read(Buffer)) != -1)
                {
                    foobj.write(Buffer, 0, iRet);
                }
                fiobj.close();
            }

            foobj.close();
        
        }
        else
        {
            System.out.println("There is no such folder");
        }
        sobj.close();
    }
}

