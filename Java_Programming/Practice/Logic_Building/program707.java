import java.util.Scanner;

public class program707
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        System.out.println("Input String is : " + str + " having length : " + str.length());

        str = str.trim();

        System.out.println("Input String is : " + str + " having length : " + str.length());

        str = str.replaceAll(" ", "");

        System.out.println("Input String is : " + str + " having length : " + str.length());

        sobj.close();
    }
}

// //s+ --> ekapeksha jast white space remove
