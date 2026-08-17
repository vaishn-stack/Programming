import java.util.*;

class Matrix
{
    protected int Arr[][];
    protected  int iRow;
    protected int iCol;

    int i = 0;
    int j = 0;

    public Matrix(int iRow, int iCol)
    {
        System.out.println("Inside Matrix constructor");

        this.iRow = iRow;
        this.iCol = iCol;

        Arr = new int[iRow][iCol];
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

class MatrixLB extends Matrix
{
    public MatrixLB(int iRow, int iCol)
    {
        super(iRow,iCol);
    }

    int iSum = 0;

    public int SummationAll()
    {
        for (i = 0; i < iRow; i++) 
        {
            for(j = 0; j < iCol; j++)
            {
                iSum = iSum + Arr[i][j];
            }

            System.out.println();
        }
        return iSum;
    }
}

public class program797
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iRow = 0, iCol = 0;
        int iRet = 0;

        System.out.println("Enter number of rows : ");
        iRow = sobj.nextInt();

        System.out.println("Enter number of Columns : ");
        iCol = sobj.nextInt();

        MatrixLB mobj = new MatrixLB(iRow, iCol);

        mobj.Accept();
        mobj.Display();

        iRet = mobj.SummationAll();

        System.out.println("Summation of all elements are : "+ iRet);

        mobj = null;

        System.gc();

        sobj.close();
    }
}
