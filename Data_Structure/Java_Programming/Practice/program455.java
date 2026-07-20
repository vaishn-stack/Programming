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
        node temp = first;

        while(temp != null)
        {
            System.out.print("| " +  temp.data + " | -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(int ino)
    {
        node newn = new node(ino);

        newn = new node(ino);

        newn.data = ino;
        newn.next = null;

        if(first == null)
        {
            this.first = newn;
        }
        else
        {
            newn.next = this.first;
            this.first = newn;
        }
        iCount++;
    }

    public void InsertLast(int ino)
    {
        node newn = new node(ino);

        newn = new node(ino);

        newn.data = ino;
        newn.next = null;

        if(first == null)
        {
            this.first = newn;
        }
        else
        {
            node temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
        iCount++;
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

public class program455
{
    public static void main(String[] args) 
    {
        SinglyLL sobj = new SinglyLL();

        int iRet = 0;

        sobj.InsertFirst(51);
        sobj.InsertFirst(21);
        sobj.InsertFirst(11);

        sobj.InsertLast(101);
        sobj.InsertLast(111);
        sobj.InsertLast(121);

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Number of nodes are :" + iRet);

        
    }
}