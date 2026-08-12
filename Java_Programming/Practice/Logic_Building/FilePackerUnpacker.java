import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FilePackerUnpacker
{
    private static final String MAGIC = "MARVELLOUS_PACKER";
    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("\n========================================");
            System.out.println("   MARVELLOUS FILE PACKER - UNPACKER");
            System.out.println("========================================");
            System.out.println("1. Pack files");
            System.out.println("2. Unpack file");
            System.out.println("3. Exit");
            System.out.print("Enter choice : ");

            String choice = sc.nextLine().trim();

            try
            {
                if(choice.equals("1"))
                {
                    System.out.print("Enter packed file name : ");
                    String packedFile = sc.nextLine().trim();

                    System.out.print("How many files to pack : ");
                    int count = Integer.parseInt(sc.nextLine().trim());

                    if(count <= 0)
                    {
                        System.out.println("Invalid file count.");
                        continue;
                    }

                    List<Path> files = new ArrayList<>();

                    for(int i = 0; i < count; i++)
                    {
                        System.out.print("Enter file " + (i + 1) + " path : ");
                        Path path = Paths.get(sc.nextLine().trim());

                        if(!Files.isRegularFile(path))
                        {
                            System.out.println("File not found: " + path);
                            i--;
                            continue;
                        }

                        files.add(path);
                    }

                    pack(packedFile, files);
                }
                else if(choice.equals("2"))
                {
                    System.out.print("Enter packed file name : ");
                    String packedFile = sc.nextLine().trim();

                    System.out.print("Enter destination directory : ");
                    String destination = sc.nextLine().trim();

                    unpack(packedFile, destination);
                }
                else if(choice.equals("3"))
                {
                    System.out.println("Thank you.");
                    break;
                }
                else
                {
                    System.out.println("Invalid choice.");
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("Please enter a valid number.");
            }
            catch(Exception e)
            {
                System.out.println("Error : " + e.getMessage());
            }
        }

        sc.close();
    }

    private static void pack(String packedFile, List<Path> files) throws IOException
    {
        Path output = Paths.get(packedFile);

        try(DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(output))))
        {
            dos.writeUTF(MAGIC);
            dos.writeInt(files.size());

            byte[] buffer = new byte[BUFFER_SIZE];

            for(Path file : files)
            {
                String fileName = file.getFileName().toString();
                long size = Files.size(file);

                dos.writeUTF(fileName);
                dos.writeLong(size);

                try(InputStream in = new BufferedInputStream(Files.newInputStream(file)))
                {
                    int bytesRead;
                    while((bytesRead = in.read(buffer)) != -1)
                    {
                        dos.write(buffer, 0, bytesRead);
                    }
                }

                System.out.println("Packed : " + fileName + " (" + size + " bytes)");
            }
        }

        System.out.println("Packing completed successfully.");
        System.out.println("Packed file : " + output.toAbsolutePath());
    }

    private static void unpack(String packedFile, String destination) throws IOException
    {
        Path input = Paths.get(packedFile);
        Path dest = Paths.get(destination);

        if(!Files.isRegularFile(input))
        {
            throw new FileNotFoundException("Packed file not found: " + input);
        }

        Files.createDirectories(dest);

        try(DataInputStream dis = new DataInputStream(
                new BufferedInputStream(Files.newInputStream(input))))
        {
            String magic = dis.readUTF();

            if(!MAGIC.equals(magic))
            {
                throw new IOException("Invalid packed file format.");
            }

            int count = dis.readInt();

            if(count < 0 || count > 100000)
            {
                throw new IOException("Invalid file count in packed file.");
            }

            byte[] buffer = new byte[BUFFER_SIZE];

            for(int i = 0; i < count; i++)
            {
                String fileName = dis.readUTF();
                long size = dis.readLong();

                if(size < 0)
                {
                    throw new IOException("Invalid file size.");
                }

                Path output = dest.resolve(fileName).normalize();

                // Prevent path traversal from a malicious packed file.
                if(!output.getParent().equals(dest.toAbsolutePath().normalize())
                        && !output.getParent().equals(dest.normalize()))
                {
                    throw new IOException("Invalid file name inside packed file: " + fileName);
                }

                try(OutputStream out = new BufferedOutputStream(Files.newOutputStream(output)))
                {
                    long remaining = size;

                    while(remaining > 0)
                    {
                        int wanted = (int)Math.min(buffer.length, remaining);
                        int bytesRead = dis.read(buffer, 0, wanted);

                        if(bytesRead == -1)
                        {
                            throw new EOFException("Packed file ended unexpectedly.");
                        }

                        out.write(buffer, 0, bytesRead);
                        remaining -= bytesRead;
                    }
                }

                System.out.println("Unpacked : " + fileName + " (" + size + " bytes)");
            }
        }

        System.out.println("Unpacking completed successfully.");
        System.out.println("Destination : " + dest.toAbsolutePath());
    }
}
