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
    private node first;
    private int iCount;

    public SinglyLL()
    {
        this.first = null;
        this.iCount = 0;
    }

    public void Display()
    {

    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(int ino)
    {
        // node newn = new node(ino);

        // newn.data = ino;
        // newn.next = null;

        // if(first == null)
        // {
        //     first = newn;
        // }
        // else
        // {
        //     newn.next = first;
        //     first = newn;
        // }
        // iCount++;
    }

    public void InsertLast(int ino)
    {
        // node newn = null;
        // node temp = null;

        // newn = new node(ino);

        // newn.data = ino;
        // newn.next = null;

        // if(first == null)
        // {
        //     first = newn;
        // }
        // else
        // {
        //     temp = first;

        //     while(temp.next != null)
        //     {
        //         temp = temp.next;
        //     }
        //     temp.next = newn;
        // }
        // iCount++;
    }
   
    public void InsertAtPos(int ino, int iPos)
    {

    }

    public void DeleteFirst()
    {

    }

    public void DeleteLast()
    {
        
    }

    public void DeleteAtPos(int iPos)
    {

    }

}

public class program452
{
    public static void main(String[] args) 
    {
        SinglyLL sobj = new SinglyLL();

        sobj.InsertFirst(11);
        sobj.InsertFirst(21);
        sobj.InsertFirst(51);

    }
}