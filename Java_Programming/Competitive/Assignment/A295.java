package Assignment59;

import java.util.Scanner;

public class A295
{
    static void addColumn(int Arr[][])
    {
        int iSum = 0;
        int i = 0, j = 0;

        for(j = 0; j < Arr[0].length; j++)
        {
            for(i = 0; i < Arr.length; i++)
            {
                iSum = iSum + Arr[i][j];
            }
            System.out.println(iSum + " ");
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
        }

        addColumn(Arr);
    }
}