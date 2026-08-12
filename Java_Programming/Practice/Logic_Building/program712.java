public class program712
{
    public static void main(String a[])
    {
        String header = "India  Is  My  Country";

        header = header.trim();

        header = header.replaceAll("\\s+"," ");

        String Arr[] = header.split(" ");

        System.out.println("Number of words are : " + Arr.length);

        for(int i = 0; i < Arr.length; i++)
        {
            System.out.println(Arr[i]);
        }
        
    }
}

