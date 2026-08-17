package Assignment60;

import java.util.Scanner;

public class A297 
{
    
    
    static void Transpose(int Arr[][], int iRow, int iCol)
    {
        int i = 0;

        for(i = 0; i < iCol; i++)
        {
            for(int j = 0; j < iRow; j++)
            {
                System.out.print(Arr[j][i] + "\t");
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
        System.out.println("Transpose of Matrix:");
        Transpose(Arr, 4, 4);
    }
}
