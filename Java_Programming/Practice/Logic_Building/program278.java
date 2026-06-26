import java.util.*;

class StringX
{
    public String Update(String str)
    {
        int i = 0;
        char Arr[] = str.toCharArray();

        for(i = 0; i < Arr.length; i++)
        {
            if(Arr[i] == 'A' || Arr[i] == 'a')        
            {
                Arr[i] = '_';
            }
        }

       String ret = new String(Arr);

       return ret;
    }
}
public class program278
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String data = null;
        StringX strobj = new StringX();       
        String sRet = null;         
        
        System.out.println("Enter the String : ");
        data = sobj.nextLine();

        sRet = strobj.Update(data);

        System.out.println("Updated string is : "+sRet);

        sobj.close();
    }
}

// string(), StringBuffer(), stringBuilder()