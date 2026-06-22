// oop coding start
/*
        iRow = 4
        iCol = 4
   
        *
        *       *
        *               *
        *                       *
        *                               *
        *       *       *       *       *       *

*/
import java.util.*;

class Pattern
{
    public void Display(int iRow, int iCol)
    {
        int i = 0;
        int j = 0;
       

        // Filter for Diagonal pattern
        if(iRow != iCol)                  // Diagonal
        {
            System.out.println("Invalid Parameter...");
            System.out.println("Number of rows and columns should be same");
            return;
        }

        for(i = 1; i <= iRow ; i++)
        {
            for(j = 1; j <= i; j++)
            {
                if((i == j) || (j == 1) || (j == iCol) || (i == 1) || (i == iRow))
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print(" \t");
                }
              
            }
          System.out.println();
    }

}
}
public class program229
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

        sobj.close();
    }
}
