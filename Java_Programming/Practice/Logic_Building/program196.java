// Non - Linear pattern Printing 
/*  iRow = 4
    iCol = 4

    # & # &
    # & # &
    # & # &
    # & # &
*/

import java.util.*;

public class program196
{
    public static void Display(int iRow, int iCol) 
    {
        int i = 0;
        int j = 0;

        for(i = 1; i <= iRow; i++)
        {
            for(j = 1; j <= iCol; j++)
            {
            //     System.out.print(i+ "\t");

                if(j % 2 == 0)
                {
                    System.out.print("&\t");
                }
                else
                {
                    System.out.print("#\t");
                }
                System.out.println();
            }
            System.out.println();

        }  
    }

    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iValue1 = 0, iValue2 = 0;

        System.out.println("Enter the Number of Rows : ");
        iValue1 = sobj.nextInt();

        System.out.println("Enter the Number of Columns : ");
        iValue2 = sobj.nextInt();

        Display(iValue1, iValue2);
    }
}