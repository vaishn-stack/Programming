import java.util.*;

class StringX
{
    public void Display(String str)
    {
        System.out.println("Received string is : "+str);
        
    }

}

public class program269
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String dataa = null;  
        StringX strobj = new StringX();                            

        System.out.println("Enter the String : ");
        dataa = sobj.nextLine();  
        
        strobj.Display(dataa);

        sobj.close();
    }
}
