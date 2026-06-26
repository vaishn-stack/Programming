import java.util.*;

public class program262
{
    public static void main(String[] A)
    {
        Scanner sobj = new Scanner(System.in);
        String Arr = null;

        System.out.println("Enter the String : ");
        Arr = sobj.nextLine();

        System.out.println(Arr.charAt(0));    
        System.out.println(Arr.charAt(1));    
        System.out.println(Arr.charAt(2));    

        sobj.close();
    }
}