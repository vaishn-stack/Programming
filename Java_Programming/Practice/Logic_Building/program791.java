import java.util.*;

class Matrix
{
    public int Arr[][];

    public Matrix(int iRow, int iCol)
    {
        System.out.println("Inside Matrix constructor");
        Arr = new int[iRow][iCol];
    }

    protected void finalize()
    {
        System.out.println("Inside finalize constructor");
        Arr = null;
        System.gc();
    }
}

public class program791
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iRow = 0, iCol = 0;

        System.out.println("Enter number of rows : ");
        iRow = sobj.nextInt();

        System.out.println("Enter number of Columns : ");
        iCol = sobj.nextInt();

        Matrix mobj = new Matrix(iRow, iCol);
        mobj = null;

        System.gc();

        // System.out.println("Enter the elemnets of Matrix : ");

        // int i = 0;
        // int j = 0;

        // for (i = 0; i < iRow; i++) 
        // {
        //     for(j = 0; j < iCol; j++)
        //     {
        //         Arr[i][j]= sobj.nextInt();
        //     }
        // }

        // System.out.println("Elemnets of the Matrix are: ");

        // for (i = 0; i < iRow; i++) 
        // {
        //     for(j = 0; j < iCol; j++)
        //     {
        //         System.out.println(Arr[i][j] + "\t");
        //     }

        //     System.out.println();
        // }
        

        sobj.close();
    }
}
