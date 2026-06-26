import java.util.*;

class StringX
{
    public void Display(String str)
    {
        System.out.println("Received string is : "+str);
        
    }

}

public class program268
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String str = null;  
        program281 strobj = new program281();                            

        System.out.println("Enter the String : ");
        str = sobj.nextLine();  
        
        strobj.Display(str);

        sobj.close();
    }
}
