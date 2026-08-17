import java.util.*;

public class program786
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        // Jagged Array
        int Arr[][] = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90, 100},
            {11, 21}
        };

        System.out.println("Number of Rows : " + Arr.length);

        System.out.println("Length of Row 0 : " + Arr[0].length);
        System.out.println("Length of Row 1 : " + Arr[1].length);
        System.out.println("Length of Row 2 : " + Arr[2].length);
        System.out.println("Length of Row 3 : " + Arr[3].length);

        System.out.println("\nElements of Jagged Array :");

        for(int i = 0; i < Arr.length; i++)
        {
            for(int j = 0; j < Arr[i].length; j++)
            {
                System.out.print(Arr[i][j] + "\t");
            }

            System.out.println();
        }

        sobj.close();
    }
}