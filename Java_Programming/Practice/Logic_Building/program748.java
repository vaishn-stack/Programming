// input - my name is amit
// output - ym eman is tima
// common question

import java.util.*;

class StringX
{
    public String WordReverse(String str)
    {
        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        String Tokens[] = str.split(" ");

        StringBuffer sb = null;
        StringBuffer FinalStr = new StringBuffer(" ");

        for(int i = 0; i < Tokens.length; i++)
        {
            sb = new StringBuffer(Tokens[i]);
            sb = sb.reverse();
            FinalStr = FinalStr.append(sb);
            FinalStr = FinalStr.append(" ");
        }

        String Output = new String(FinalStr);

        Output = Output.trim();

        System.out.println(Output);

        return Output;
    }

}

public class program748
{
    public static void main(String a[])
    {
        Scanner sobj = new Scanner(System.in);

        StringX strobj = new StringX();

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        String sRet = strobj.WordReverse(str);

        System.out.println(sRet);

        sobj.close();
    }
}


