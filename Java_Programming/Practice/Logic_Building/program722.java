
public class program722
{
    public static void main(String a[])
    {
        String header = "Hello.txt 1078";

        System.out.println("Actual header length : " + header.length());

        System.out.println("Number of white spaces we need : " + (100 - header.length()));

        int Size = 100 - header.length();

        // System.out.println("Size variable : " + Size);

        for(int i = 1; i <= Size; i++)
        {
            header = header + " ";
        }

        System.out.println("Updated header length is : " + header.length());
        System.out.println("Updated header is : " + header);
    }
}


// Imp for Interview