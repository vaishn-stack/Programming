import java.util.*;

interface GetterSetter
{
    void Accept();
    void Display();
}

class ArrayX implements GetterSetter
{
    public int Arr[];
    public int iSize;

    public ArrayX(int iSize)
    {
        this.iSize = iSize;
        Arr = new int[iSize];
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the elements of array : ");

        for(int i = 0; i < this.iSize; i++)
        {
            Arr[i] = sobj.nextInt();
        }
    }

    public void Display()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Elements of the array are : ");
        
        for(int i = 0; i < this.iSize; i++)
        {
           System.out.println(Arr[i] + "\t");
        }
    }
}
public class program870
{
    public static void main(String A[])
    {
        ArrayX aobj = new ArrayX(5);

        aobj.Accept();
        aobj.Display();
    }
}
