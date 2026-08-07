import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class A243
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter directory name : ");
        String DirName = sobj.nextLine();

        File dobj = new File(DirName);

        if(dobj.exists() && dobj.isDirectory())
        {
            File Arr[] = dobj.listFiles();

            try
            {
                FileOutputStream foobj =
                    new FileOutputStream("Marvellous.txt");

                for(int i = 0; i < Arr.length; i++)
                {
                    if(Arr[i].isFile())
                    {
                        try
                        {
                            FileInputStream fiobj =
                                new FileInputStream(Arr[i]);

                            int Data;

                            while((Data = fiobj.read()) != -1)
                            {
                                foobj.write(Data);
                            }

                            fiobj.close();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Unable to read : "
                                               + Arr[i].getName());
                        }
                    }
                }

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
            System.out.println("Directory does not exist.");
        }

        sobj.close();
    }
}