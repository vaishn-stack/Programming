import java.util.*;

public class program267
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        String str= new String();                               // new keyword mule constructor used krta yeto 

        System.out.println(str.length());                       // Elastic type ne chalat jas jashi length lagte tashi ti vadt jate

        System.out.println("Enter the String : ");
        str = sobj.nextLine();                                  // It is used multi word 

        System.out.println("String is : "+str);

        System.out.println(str.length());

        sobj.close();
    }
}
