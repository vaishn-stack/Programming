import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class program732
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);

        String PackFileName = null;
        File fpackobj = null;
        FileInputStream fiobj = null;
        FileOutputStream foobj = null;

        byte Header[] = new byte[100];
        byte Buffer[] = null;

        String Tokens[] = null;
        String strHeader = null;

        File NewFile = null;

        System.out.println("Enter the Name of Packed File : ");
        PackFileName = sobj.nextLine();

        fpackobj = new File(PackFileName);

        if(fpackobj.exists())
        {
            fiobj = new FileInputStream(fpackobj);

            // Read Header
            int iRet = fiobj.read(Header, 0, 100);

            if(iRet != 100)
            {
                System.out.println("Invalid packed file.");
                fiobj.close();
                sobj.close();
                return;
            }

            strHeader = new String(Header);

            System.out.println("Header is : " + strHeader);

            // Remove extra spaces
            strHeader = strHeader.trim();
            strHeader = strHeader.replaceAll("\\s+", " ");

            // Split Header
            Tokens = strHeader.split(" ");

            if(Tokens.length < 2)
            {
                System.out.println("Invalid header format.");
                fiobj.close();
                sobj.close();
                return;
            }

            System.out.println("File Name : " + Tokens[0]);
            System.out.println("File Size : " + Tokens[1]);

            // Create New File
            NewFile = new File(Tokens[0]);

            if(NewFile.exists())
            {
                System.out.println("File already exists.");
            }
            else
            {
                NewFile.createNewFile();
            }

            // Open output stream
            foobj = new FileOutputStream(NewFile);

            // Allocate buffer according to original file size
            int FileSize = Integer.parseInt(Tokens[1]);

            Buffer = new byte[FileSize];

            // Read Data
            int iRet2 = fiobj.read(Buffer, 0, FileSize);

            // Write Data
            if(iRet2 == FileSize)
            {
                foobj.write(Buffer, 0, FileSize);

                System.out.println("File extracted successfully.");
            }
            else
            {
                System.out.println("Unable to extract complete file.");
            }

            // Close streams
            foobj.close();
            fiobj.close();
        }
        else
        {
            System.out.println("There is no such pack file.");
        }

        sobj.close();
    }
}