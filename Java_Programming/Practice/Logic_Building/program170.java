import java.util.Scanner;

class ArrayX
{
    private int Arr[];
    private int iSize;

    // Parameterized Constructor
    public ArrayX(int X)
    {
        iSize = X;
        Arr = new int[iSize];
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the elements : ");

        for(int iCnt = 0; iCnt < iSize; iCnt++)
        {
            Arr[iCnt] = sobj.nextInt();
        }
    }

     public void Display()
    {
        System.out.println("Elements of the array are : ");

        for(int iCnt = 0; iCnt < iSize; iCnt++)
        {
            System.out.println(Arr[iCnt]);
        }
    }
}

public class program170
{
    public static void main(String A[])
    {

        Scanner sobj = new Scanner(System.in);

        int iLength = 0;

        System.out.println("Enter the number of elements : ");
        iLength = sobj.nextInt();

        ArrayX aobj = new ArrayX(iLength);

        aobj.Accept();
        aobj.Display();
    }
}
