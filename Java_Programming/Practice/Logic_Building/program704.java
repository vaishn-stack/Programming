public class program704
{
    public static void main(String a[])
    {
        String header = "    India   Is   My   Country    ";

        System.out.println(header.length());

        header = header.trim();

        System.out.println(header.length());
        
        header = header.replaceAll("  ", " "); 
        
        System.out.println(header.length());

        header = header.replaceAll("  ", " "); 
        
        System.out.println(header.length());
    }
}
