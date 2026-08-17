package Assignment60;

import java.util.Scanner;

public class A301
{   
    static boolean ChkSparse(int Arr[][], int iRow, int iCol)
    {
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int nonzeroCount = 0;

        if(iRow != iCol)
        {
            return false;
        }

        for(i = 0; i < iRow; i++)
        {
            for(j = 0; j < iCol; j++)
            {
                if(Arr[i][j] == 0)
                {
                    zeroCount++;
                }
                else
                {
                    nonzeroCount++;
                }
            }
        }

        if(zeroCount > nonzeroCount)
        {
            return true;
        }

        return false;
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

        if(ChkSparse(Arr, 4, 4))
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }
}
