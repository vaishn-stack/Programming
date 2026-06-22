// oop coding start
/*
        iRow = 4
        iCol = 4
   
        a 
        bb
        ccc 
        dddd
*/
import java.util.*;

class Pattern
{
    public void Display(int iRow, int iCol)
    {
        int i = 0;
        int j = 0;
        char ch = '\0';

        // Filter for Diagonal pattern
        if(iRow != iCol)                  // Diagonal
        {
            System.out.println("Invalid Parameter...");
            System.out.println("Number of rows and columns should be same");
            return;
        }

        for(i = 1,ch = 'a'; i <= iRow ; i++,ch++)
        {
            for(j = 1; j <= i; j++)
            {
                
                System.out.print(ch+ "\t");
              
            }
          System.out.println();
    }

}
}
public class program226
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iValue1 = 0;
        int iValue2 = 0;

        System.out.println("Enter number of rows : ");
        iValue1 = sobj.nextInt();

        System.out.println("Enter number of columns : ");
        iValue2 = sobj.nextInt();

        Pattern pobj = new Pattern();

        pobj.Display(iValue1, iValue2);
    }
}
