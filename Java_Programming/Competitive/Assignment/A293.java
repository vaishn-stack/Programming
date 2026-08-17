package Assignment59;

import java.util.Scanner;

public class A293
{
    static int countNumber(int Arr[][], int ino)
    {
        int iCount = 0;
        int i = 0, j = 0;

        for(i = 0; i < Arr.length; i++)
        {
            for(j = 0; j < Arr[i].length; j++)
            {
                if(Arr[i][j] == ino)
                {
                    iCount++;
                }
            }
        }

        return iCount;
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

        int ino = sobj.nextInt();

        System.out.println(countNumber(Arr, ino));
    }
}