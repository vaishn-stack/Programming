import java.util.*;

class A285
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for(int i = 0; i < str.length(); i++)
        {
            int icount = 0;

            for(int j = 0; j < str.length(); j++)
            {
                if(str.charAt(i) == str.charAt(j))
                    icount++;
            }

            if(icount > 1 && str.indexOf(str.charAt(i)) == i)
                System.out.print(str.charAt(i) + " ");
        }
    }
}