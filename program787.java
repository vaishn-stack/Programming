import java.util.*;

public class program787
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int Arr[][] = {
            {10,20,30},
            {40,50,60},
            {70,80,90}
        };

        System.out.println(Arr.length);

        System.out.println(Arr[0].length);
        System.out.println(Arr[1].length);
        System.out.println(Arr[2].length);

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