class node
{
    public int data;
    public node next;

    node(int no)
    {
        this.data = no;
        this.next = null;
    }
}

class SinglyLL
{
    public node first;
    public int iCount;

    public SinglyLL()
    {
        System.out.println("Inside Constructor");
        this.first = null;
        this.iCount = 0;
    }

    // public void Display()
    // {

    // }

    // public int Count()
    // {

    // }

    // public void InsertFirst()
    // {

    // }
}

public class program451
{
    public static void main(String[] args) 
    {
        SinglyLL sobj = new SinglyLL();


    }
}