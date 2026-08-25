import java.util.*;

interface GetterSetter
{
    void Accept();
    void Display();
}

class ArrayX implements GetterSetter
{
    protected int Arr[];
    protected int iSize;

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

        System.out.println("Elements of the array are : \n");
        
        for(int i = 0; i < this.iSize; i++)
        {
           System.out.print(Arr[i] + "\t");
        }
    }
}



final class Sorting extends ArrayX
{
    public boolean IsSorted;

    public Sorting(int iSize)
    {
        super(iSize);
        IsSorted = false;
    }

    public void BubbleSort()
    {
        int i = 0, j = 0, temp = 0, pass = 0;

        if(IsSorted == true)
        {
            return;
        }

        for(i = 0, pass = 1; i < iSize - 1; i++, pass++)
        {
            for(j = 0; j < iSize - 1 - i; j++)
            {
                if(Arr[j] > Arr[j + 1])
                {
                    temp = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = temp;
                }
            }

            System.out.println("Data After Pass : " + pass);
            Display();
        }
        IsSorted = true;
    }

    public void BubbleSortEfficient()
    {
        int i = 0, j = 0, temp = 0;
        boolean bFlag = false;

        bFlag = true;

        if(IsSorted == true)
        {
            return;
        }

        for(i = 0; i < iSize - 1; i++)
        {
            if(bFlag == false)
            {
                break;
            }
            
            bFlag = false;

            for(j = 0; j < iSize - 1 - i; j++)
            {
                if(Arr[j] > Arr[j + 1])
                {
                    temp = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = temp;

                    bFlag = true;           // Imp
                }
            }
        }
        IsSorted = true;
    }

    public void SelectionSort()
    {
        int i = 0, j = 0, temp = 0;

        int min_index = 0;

        if(IsSorted == true)
        {
            return;
        }

        for(i = 0; i < iSize - 1; i++)
        {
            min_index = i;

            for(j = i + 1; j < iSize; j++)
            {
                if(Arr[j] < Arr[min_index])
                {
                    min_index = j;
                }
            }

            temp = Arr[i];
            Arr[i] = Arr[min_index];
            Arr[min_index] = temp;
        }
    }
}

public class program897
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the number of elements : ");
        int iSize = sobj.nextInt();
        
        Sorting srobj = new Sorting(iSize);

        srobj.Accept();
        srobj.Display();

        srobj.SelectionSort();

        System.out.println("Final Sorted Array : ");
        srobj.Display();

        srobj = null;
        System.gc();

        sobj.close();
    }
}

// time complexity - N/2
