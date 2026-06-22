// oop coding start
/*
        iRow = 4
        iCol = 4

        4 4 4 4
        3 3 3 3
        2 2 2 2
        1 1 1 1
*/
import java.util.*;

class Pattern
{
    public void Display(int iRow, int iCol)
    {
        int i = 0;
        int j = 0;
        int iCount = 0;

        for(i = 1,  iCount = iRow ; i <= iRow ; i++, iCount--)
        {
            for(j = 1; j <= iCol; j++)
        
            {
                System.out.print(iCount + "\t");
            }

            System.out.println();
        }
    }
}

public class program207
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
