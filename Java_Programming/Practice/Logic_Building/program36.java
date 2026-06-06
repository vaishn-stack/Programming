// Problems on  - numbers, digits, n numbers
import java.util.*;

public class program36
{
    public static void main(String A[])     
    { 
        Scanner sobj = new Scanner(System.in);

        String sName = null;
        int iAge = 0;
        float fMarks = 0.0f;

        System.out.println("Enter Your Name : ");
        sName = sobj.nextLine();

        System.out.println("Enter Your Age : ");
        iAge = sobj.nextInt();

        System.out.println("Enter Your Marks : ");
        fMarks = sobj.nextFloat();

        System.out.println("-------------------------------------------");
        System.out.println("Name : "+sName);
        System.out.println("Age : "+iAge);
        System.out.println("Marks : "+fMarks);
    }
}