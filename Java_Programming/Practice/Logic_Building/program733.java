import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class program733
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);

        int iRet = 0;
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

            while(true)
            {
                // Read 100 byte Header
                int HeaderRead = 0;

                while(HeaderRead < 100)
                {
                    iRet = fiobj.read(Header, HeaderRead, 100 - HeaderRead);

                    if(iRet == -1)
                    {
                        break;
                    }

                    HeaderRead = HeaderRead + iRet;
                }

                // End of packed file
                if(HeaderRead == 0)
                {
                    break;
                }

                // Invalid / incomplete header
                if(HeaderRead != 100)
                {
                    System.out.println("Invalid packed file.");
                    break;
                }

                // Convert Header into String
                strHeader = new String(Header);

                System.out.println("\nHeader is : " + strHeader);

                // Remove extra spaces
                strHeader = strHeader.trim();
                strHeader = strHeader.replaceAll("\\s+", " ");

                // Split Header
                Tokens = strHeader.split(" ");

                if(Tokens.length < 2)
                {
                    System.out.println("Invalid Header.");
                    break;
                }

                System.out.println("File Name : " + Tokens[0]);
                System.out.println("File Size : " + Tokens[1]);

                int FileSize = Integer.parseInt(Tokens[1]);

                // Create New File
                NewFile = new File(Tokens[0]);

                if(NewFile.exists())
                {
                    System.out.println("File already exists. Overwriting...");
                }

                foobj = new FileOutputStream(NewFile);

                // Create Buffer
                Buffer = new byte[FileSize];

                // Read File Data
                int DataRead = 0;

                while(DataRead < FileSize)
                {
                    iRet = fiobj.read(Buffer, DataRead, FileSize - DataRead);

                    if(iRet == -1)
                    {
                        break;
                    }

                    DataRead = DataRead + iRet;
                }

                // Check complete data is read or not
                if(DataRead != FileSize)
                {
                    System.out.println("Unable to read complete file data.");
                    foobj.close();
                    break;
                }

                // Write File Data
                foobj.write(Buffer, 0, FileSize);

                System.out.println("File extracted successfully.");

                // Close output file
                foobj.close();

                foobj = null;
            }

            // Close packed file
            fiobj.close();

            System.out.println("\nAll files extracted successfully.");
        }
        else
        {
            System.out.println("There is no such pack file.");
        }

        sobj.close();
    }
}