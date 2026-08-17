import java.util.*;

public class program789
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iRow = 0, iCol = 0;

        System.out.println("Enter number of rows : ");
        iRow = sobj.nextInt();

        System.out.println("Enter number of Columns : ");
        iCol = sobj.nextInt();

        int Arr[][] = new int[iRow][iCol];

        System.out.println("Enter the elemnets of Matrix : ");

        int i = 0;
        int j = 0;

        for (i = 0; i < iRow; i++) 
        {
            for(j = 0; j < iCol; j++)
            {
                Arr[i][j]= sobj.nextInt();
            }
        }

        System.out.println("Elemnets of the Matrix are: ");

        for (i = 0; i < iRow; i++) 
        {
            for(j = 0; j < iCol; j++)
            {
                System.out.print(Arr[i][j] + "\t");
            }

            System.out.println();
        }
        

        sobj.close();
    }
}
