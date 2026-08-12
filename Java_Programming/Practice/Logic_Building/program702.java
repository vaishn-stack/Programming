public class program702
{
    public static void main(String a[])
    {
        String header = "    India  Is  My  Country    ";

        System.out.println(header);

        header = header.trim();

        System.out.println(header);
        
        header = header.replaceAll("  ", " "); 
        
        System.out.println(header);
    }
}
