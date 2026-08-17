package Assignment59;

import java.util.Scanner;

public class A294
{
    static int maxDiagonal(int Arr[][])
    {
        int iMax = Arr[0][0];
        int n = Arr.length;
        int i = 0;

        for(i = 0; i < n; i++)
        {
            if(Arr[i][i] > iMax)
            {
                iMax = Arr[i][i];
            }

            if(Arr[i][n - 1 - i] > iMax)
            {
                iMax = Arr[i][n - 1 - i];
            }
        }

        return iMax;
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
        }

        System.out.println(maxDiagonal(Arr));
    }
}