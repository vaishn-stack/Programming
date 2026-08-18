import java.util.*;

class Matrix<T extends Number>
{
    protected T Arr[][];
    protected int iRow;
    protected int iCol;

    public Matrix(int iRow, int iCol)
    {
        System.out.println("Inside Matrix constructor");

        this.iRow = iRow;
        this.iCol = iCol;

        Arr = (T[][]) new Number[iRow][iCol];
    }

    public void Accept(T values[])
    {
        int k = 0;

        System.out.println("Enter the elements of Matrix : ");

        for(int i = 0; i < iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                Arr[i][j] = values[k];
                k++;
            }
        }
    }

    public void Display()
    {
        System.out.println("Elements of the Matrix are : ");

        for(int i = 0; i < iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                System.out.print(Arr[i][j] + "\t");
            }

            System.out.println();
        }
    }
}

class MatrixLB<T extends Number> extends Matrix<T>
{
    public MatrixLB(int iRow, int iCol)
    {
        super(iRow, iCol);
    }

    public double SummationAll()
    {
        double iSum = 0;

        for(int i = 0; i < iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                iSum = iSum + Arr[i][j].doubleValue();
            }
        }

        return iSum;
    }

    public void SummationRow()
    {
        for(int i = 0; i < iRow; i++)
        {
            double iSum = 0;

            for(int j = 0; j < iCol; j++)
            {
                iSum = iSum + Arr[i][j].doubleValue();
            }

            System.out.println(
                "Summation of row no " + i + " is : " + iSum
            );
        }
    }

    public double MaximumAll()
    {
        double iMax = Arr[0][0].doubleValue();

        for(int i = 0; i < iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                if(Arr[i][j].doubleValue() > iMax)
                {
                    iMax = Arr[i][j].doubleValue();
                }
            }
        }

        return iMax;
    }

    public double MinimumAll()
    {
        double iMin = Arr[0][0].doubleValue();

        for(int i = 0; i < iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                if(Arr[i][j].doubleValue() < iMin)
                {
                    iMin = Arr[i][j].doubleValue();
                }
            }
        }

        return iMin;
    }
}

public class program801
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iRow = 0;
        int iCol = 0;

        System.out.println("Enter number of rows : ");
        iRow = sobj.nextInt();

        System.out.println("Enter number of Columns : ");
        iCol = sobj.nextInt();

        MatrixLB<Integer> mobj =
            new MatrixLB<Integer>(iRow, iCol);

        Integer values[] = new Integer[iRow * iCol];

        System.out.println("Enter the elements of Matrix : ");

        for(int i = 0; i < values.length; i++)
        {
            values[i] = sobj.nextInt();
        }

        mobj.Accept(values);
        mobj.Display();

        double iRet = mobj.SummationAll();

        System.out.println(
            "Summation of all elements are : " + iRet
        );

        mobj.SummationRow();

        iRet = mobj.MaximumAll();

        System.out.println(
            "Maximum number is : " + iRet
        );

        iRet = mobj.MinimumAll();

        System.out.println(
            "Minimum number is : " + iRet
        );

        mobj = null;

        System.gc();

        sobj.close();
    }
}