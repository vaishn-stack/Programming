import java.util.*;

public class program888
{
    public static void main(String a[])
    {
        Integer Arr[] = {10,13,34,21,15,7,24};

        for(int no : Arr)
        {
            System.out.print(no + "\t");
        }
        System.out.println();

        int index = Arrays.binarySearch(Arr, 27);

        if(index >= 0)
        {
            System.out.println("Elements is present");
        }
        else
        {
            System.out.println("There is no such elements");
        }

        for(int no : Arr)
        {
            System.out.print(no + "\t");
        }
        System.out.println();
    }
}
