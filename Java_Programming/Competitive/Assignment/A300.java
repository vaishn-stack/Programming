package Assignment60;

import java.util.Scanner;

public class A300
{   
    static boolean ChkIdentity(int Arr[][], int iRow, int iCol)
    {
        int i = 0;
        int j = 0;

        if(iRow != iCol)
        {
            return false;
        }

        for(i = 0; i < iRow; i++)
        {
            for(j = 0; j < iCol; j++)
            {
                if(i == j)
                {
                    if(Arr[i][j] != 1)
                    {
                        return false;
                    }
                }
                else
                {
                    if(Arr[i][j] != 0)
                    {
                        return false;
                    }
                }
            }
        }

        return true;
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

        if(ChkIdentity(Arr, 4, 4))
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }
}
