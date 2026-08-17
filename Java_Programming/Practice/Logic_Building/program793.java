import java.util.*;

class Matrix
{
    private int Arr[][];
    private int iRow;
    private int iCol;

    int i = 0;
    int j = 0;

    public Matrix(int iRow, int iCol)
    {
        System.out.println("Inside Matrix constructor");

        this.iRow = iRow;
        this.iCol = iCol;

        Arr = new int[iRow][iCol];
    }

    protected void finalize()
    {
        System.out.println("Inside finalize method");
        Arr = null;
        System.gc();
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the elemnets of Matrix : ");

        for (i = 0; i < iRow ; i++) 
        {
            for(j = 0; j < iCol; j++)
            {
                Arr[i][j]= sobj.nextInt();
            }
        }
    }

    public void Display()
    {
        System.out.println("Elemnets of the Matrix are: ");

        for (i = 0; i < iRow; i++) 
        {
            for(j = 0; j < iCol; j++)
            {
                System.out.print(Arr[i][j] + "\t");
            }

            System.out.println();
        }
    }
}

public class program793
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

        mobj.Accept();
        mobj.Display();

        System.gc();

        sobj.close();
    }
}
