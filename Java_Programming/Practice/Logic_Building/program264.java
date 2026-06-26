import java.util.*;

public class program264
{
    public static void main(String[] A)
    {
        Scanner sobj = new Scanner(System.in);
        String Arr = null;

        System.out.println("Enter the String : ");
        Arr = sobj.nextLine();

        System.out.println("Length of String is : "+ Arr.length());  
        
        int i = 0;
        
        for(i = 0; i < Arr.length(); i++)
        {
            System.out.println(Arr.charAt(i));
        }

        sobj.close();
    }
}