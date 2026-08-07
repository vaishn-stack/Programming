import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class A245
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
                        String Name = Arr[i].getName();
                        long Size = Arr[i].length();

                        foobj.write(("File Name : " + Name + "\n")
                                    .getBytes());

                        foobj.write(("File Size : " + Size + " bytes\n")
                                    .getBytes());

                        foobj.write("File Data :\n".getBytes());

                        FileInputStream fiobj =
                            new FileInputStream(Arr[i]);

                        int Data;

                        while((Data = fiobj.read()) != -1)
                        {
                            foobj.write(Data);
                        }

                        foobj.write("\n-------------------------\n"
                                    .getBytes());

                        fiobj.close();
                    }
                }

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
            System.out.println("Directory does not exist.");
        }

        sobj.close();
    }
}