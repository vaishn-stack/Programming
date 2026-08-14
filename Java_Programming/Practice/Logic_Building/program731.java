import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class program731
{
    public static void main(String a[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);

        String PackFileName = null;
        File fpackobj = null;

        FileInputStream fiobj = null;
        byte Header[] = new byte[100];

        String strHeader = null;
        String Tokens[] = null;

        File NewFile = null;

        System.out.println("Enter the Name of Packed File : ");
        PackFileName = sobj.nextLine();

        fpackobj = new File(PackFileName);

        if(fpackobj.exists())
        {
            fiobj = new FileInputStream(fpackobj);

            fiobj.read(Header, 0 , 100);

            strHeader = new String(Header);

            System.out.println("Header is : " + strHeader);

            strHeader = strHeader.trim();
            strHeader = strHeader.replaceAll("\\s+", " ");

            Tokens = strHeader.split(" ");
            
            System.out.println("File Name : "+ Tokens[0]);
            System.out.println("File Size : "+ Tokens[1]);

            NewFile = new File(Tokens[0]);
            NewFile.createNewFile();
        }
        else
        {
            System.out.println("There is no such pack file");
        }


        sobj.close();
    }
}