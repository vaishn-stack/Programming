import java.util.*;
// capital letter chi ascii value madhun small letter chi ascii value minus kelyavr 32 as yet 
class StringX
{
    public String toUpperX(String str)
    {
        int i = 0;
        char Arr[] = str.toCharArray();

        for(i = 0; i < Arr.length; i++)
        {
            
                Arr[i] = (char)(Arr[i] - 32);      // Issue
            
        }

       return new String(Arr);
    }
}
public class program285
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String data = null;
        StringX strobj = new StringX();       
        String sRet = null;         
        
        System.out.println("Enter the String : ");
        data = sobj.nextLine();

        sRet = strobj.toUpperX(data);

        System.out.println("Updated string is : "+sRet);

        sobj.close();
    }
}

// string(), StringBuffer(), stringBuilder()