package Assignment60;

import java.util.Scanner;

public class A298
{    
    static void ReverseRow(int Arr[][], int iRow, int iCol)
    {
        int i = 0;
        int j = 0;

        for(i = 0; i < iCol; i++)
        {
            int iStart = 0;
            int iEnd = 0;

            iEnd = iCol - 1;

            while(iStart < iEnd)
            {
                int itemp = 0;
                itemp = Arr[i][iStart];
                Arr[i][iStart] = Arr[i][iEnd];
                Arr[i][iEnd] = itemp;

                iStart++;
                iEnd--;
            }
        }

        for(i = 0; i < iRow; i++)
        {
            for(j = 0; j < iCol; j++)
            {
                System.out.print(Arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        int Arr[][] = new int[4][4];

        System.out.println("Enter matrix elements:");

        int i = 0 , j = 0;

        for(i = 0; i < 4; i++)
        {
            for(j = 0; j < 4; j++)
            {
                Arr[i][j] = sobj.nextInt();
            }
        }
        System.out.println("After reversing each row:");
        ReverseRow(Arr, 4, 4);
    }
}
