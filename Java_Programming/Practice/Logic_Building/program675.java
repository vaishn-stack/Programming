

public class program675
{
    public static void main(String a[]) 
    {
        String Data = "Marvellous Infosystems";

        byte Arr[] = Data.getBytes();

        System.out.println(Data.length());
        System.out.println(Arr.length);

        for(int i = 0; i < Arr.length; i++)
        {
            System.out.println((char)Arr[i]);
        }
    }
}

