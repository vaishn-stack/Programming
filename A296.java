package Assignment59;

import java.util.Scanner;

public class A296
{
    static void swapRows(int Arr[][])
    {
        int i = 0;

        for(i = 0; i < Arr.length - 1; i = i + 2)
        {
            int itemp[] = Arr[i];
            Arr[i] = Arr[i + 1];
            Arr[i + 1] = itemp;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        int Arr[][] = new int[4][4];
        int i = 0, j = 0;

        for(i = 0; i < 4; i++)
        {
            for(j = 0; j < 4; j++)
            {
                Arr[i][j] = sobj.nextInt();
            }
            System.out.println();
        }

        swapRows(Arr);
    }
}